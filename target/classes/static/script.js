// URL base da API
const API_URL = 'http://localhost:8080/filmes';

// Elementos do DOM
const filmeForm = document.getElementById('filmeForm');
const filmesList = document.getElementById('filmesList');
const loading = document.getElementById('loading');
const emptyState = document.getElementById('emptyState');
const refreshBtn = document.getElementById('refreshBtn');
const cancelBtn = document.getElementById('cancelBtn');
const confirmModal = document.getElementById('confirmModal');
const confirmDeleteBtn = document.getElementById('confirmDeleteBtn');
const cancelDeleteBtn = document.getElementById('cancelDeleteBtn');

// Estado
let editingFilmeId = null;
let deleteFilmeId = null;

// Inicialização
document.addEventListener('DOMContentLoaded', () => {
    carregarFilmes();
    
    // Event Listeners
    filmeForm.addEventListener('submit', handleSubmit);
    refreshBtn.addEventListener('click', carregarFilmes);
    cancelBtn.addEventListener('click', cancelarEdicao);
    confirmDeleteBtn.addEventListener('click', confirmarDelete);
    cancelDeleteBtn.addEventListener('click', () => {
        confirmModal.style.display = 'none';
        deleteFilmeId = null;
    });
});

// Carregar todos os filmes
async function carregarFilmes() {
    try {
        showLoading();
        const response = await fetch(API_URL);
        
        if (!response.ok) {
            throw new Error('Erro ao carregar filmes');
        }
        
        const filmes = await response.json();
        exibirFilmes(filmes);
    } catch (error) {
        console.error('Erro:', error);
        showError('Erro ao carregar filmes. Verifique se o servidor está rodando.');
    } finally {
        hideLoading();
    }
}

// Exibir filmes na tela
function exibirFilmes(filmes) {
    filmesList.innerHTML = '';
    
    if (filmes.length === 0) {
        emptyState.style.display = 'block';
        return;
    }
    
    emptyState.style.display = 'none';
    
    filmes.forEach(filme => {
        const card = criarFilmeCard(filme);
        filmesList.appendChild(card);
    });
}

// Criar card de filme
function criarFilmeCard(filme) {
    const card = document.createElement('div');
    card.className = 'filme-card';
    
    const dataFormatada = filme.dataLancamento 
        ? new Date(filme.dataLancamento + 'T00:00:00').toLocaleDateString('pt-BR')
        : 'Data não informada';
    
    const orcamentoFormatado = filme.orcamento 
        ? filme.orcamento.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })
        : 'R$ 0,00';
    
    card.innerHTML = `
        <h3>${filme.titulo}</h3>
        <div class="filme-info">
            <p><strong>Data de Lançamento:</strong> ${dataFormatada}</p>
            <p><strong>Descrição:</strong> ${filme.descricao || 'Sem descrição'}</p>
        </div>
        <div class="filme-orcamento">
            💰 ${orcamentoFormatado}
        </div>
        <div class="filme-actions">
            <button class="btn btn-warning" onclick="editarFilme(${filme.id})">
                ✏️ Editar
            </button>
            <button class="btn btn-danger" onclick="solicitarDelete(${filme.id})">
                🗑️ Excluir
            </button>
        </div>
    `;
    
    return card;
}

// Manipular submissão do formulário
async function handleSubmit(e) {
    e.preventDefault();
    
    const filme = {
        titulo: document.getElementById('titulo').value,
        dataLancamento: document.getElementById('dataLancamento').value || null,
        orcamento: parseFloat(document.getElementById('orcamento').value),
        descricao: document.getElementById('descricao').value || null
    };
    
    try {
        if (editingFilmeId) {
            await atualizarFilme(editingFilmeId, filme);
        } else {
            await criarFilme(filme);
        }
        
        limparFormulario();
        carregarFilmes();
    } catch (error) {
        console.error('Erro:', error);
        showError('Erro ao salvar filme.');
    }
}

// Criar novo filme
async function criarFilme(filme) {
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(filme)
    });
    
    if (!response.ok) {
        throw new Error('Erro ao criar filme');
    }
    
    showSuccess('Filme criado com sucesso!');
}

// Atualizar filme existente
async function atualizarFilme(id, filme) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(filme)
    });
    
    if (!response.ok) {
        throw new Error('Erro ao atualizar filme');
    }
    
    showSuccess('Filme atualizado com sucesso!');
}

// Editar filme
async function editarFilme(id) {
    try {
        const response = await fetch(`${API_URL}/${id}`);
        
        if (!response.ok) {
            throw new Error('Erro ao buscar filme');
        }
        
        const filme = await response.json();
        
        document.getElementById('titulo').value = filme.titulo;
        document.getElementById('dataLancamento').value = filme.dataLancamento || '';
        document.getElementById('orcamento').value = filme.orcamento;
        document.getElementById('descricao').value = filme.descricao || '';
        
        editingFilmeId = id;
        
        // Atualizar UI
        const submitBtn = filmeForm.querySelector('.btn-primary .btn-text');
        submitBtn.textContent = 'Atualizar Filme';
        cancelBtn.style.display = 'inline-flex';
        
        // Scroll para o formulário
        document.querySelector('.form-section').scrollIntoView({ behavior: 'smooth' });
        
    } catch (error) {
        console.error('Erro:', error);
        showError('Erro ao carregar filme para edição.');
    }
}

// Solicitar exclusão
function solicitarDelete(id) {
    deleteFilmeId = id;
    confirmModal.style.display = 'flex';
}

// Confirmar exclusão
async function confirmarDelete() {
    if (!deleteFilmeId) return;
    
    try {
        const response = await fetch(`${API_URL}/${deleteFilmeId}`, {
            method: 'DELETE'
        });
        
        if (!response.ok) {
            throw new Error('Erro ao excluir filme');
        }
        
        showSuccess('Filme excluído com sucesso!');
        carregarFilmes();
        
    } catch (error) {
        console.error('Erro:', error);
        showError('Erro ao excluir filme.');
    } finally {
        confirmModal.style.display = 'none';
        deleteFilmeId = null;
    }
}

// Cancelar edição
function cancelarEdicao() {
    limparFormulario();
}

// Limpar formulário
function limparFormulario() {
    filmeForm.reset();
    editingFilmeId = null;
    
    const submitBtn = filmeForm.querySelector('.btn-primary .btn-text');
    submitBtn.textContent = 'Adicionar Filme';
    cancelBtn.style.display = 'none';
}

// Funções auxiliares
function showLoading() {
    loading.style.display = 'block';
    filmesList.style.display = 'none';
    emptyState.style.display = 'none';
}

function hideLoading() {
    loading.style.display = 'none';
    filmesList.style.display = 'grid';
}

function showSuccess(message) {
    alert('✅ ' + message);
}

function showError(message) {
    alert('❌ ' + message);
}
