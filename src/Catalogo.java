
import java.util.*;

public class Catalogo {
    private List<Filme> filmes = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private int pedirIndice(List<?> lista, String tipo, boolean permitirZero) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum " + tipo + " cadastrado.");
            return -1;
        }
        listar(lista, tipo);
        System.out.println("Número do " + tipo + (permitirZero ? " (0 para cancelar)" : "") + ":");
        int i = lerInt(sc.nextLine());
        if (permitirZero && i == 0) return -1;
        if (i < 1 || i > lista.size()) {
            System.out.println("Número inválido.");
            return -1;
        }
        return i - 1;
    }

    private void listar(List<?> lista, String tipo) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
    }

    private int lerInt(String entrada) {
        try {
            return Integer.parseInt(entrada);
        } catch (Exception e) {
            return -1;
        }
    }

    private String lerTexto(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public void cadastrarFilme() {
        String titulo = lerTexto("Título: ");
        String dataLancamento = lerTexto("Data de lançamento: ");
        double orcamento = Double.parseDouble(lerTexto("Orçamento: R$ "));
        String descricao = lerTexto("Descrição: ");
        String nomeDiretor = lerTexto("Nome do diretor: ");

        Diretor diretor = buscarOuCriarDiretor(nomeDiretor);

        Filme filme = new Filme(titulo, dataLancamento, orcamento, descricao);
        filme.setDiretor(diretor);
        filmes.add(filme);
        System.out.println("Filme cadastrado.");
    }

    public void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        listar(filmes, "filme");
    }

    public void editarFilme() {
        int i = pedirIndice(filmes, "filme", false);
        if (i == -1) return;

        Filme f = filmes.get(i);

        String t = lerTexto("Novo título (enter para manter '" + f.getTitulo() + "'): ");
        if (!t.isEmpty()) f.setTitulo(t);

        String dl = lerTexto("Nova data de lançamento (enter para manter '" + f.getDataLancamento() + "'): ");
        if (!dl.isEmpty()) f.setDataLancamento(dl);

        String oStr = lerTexto("Novo orçamento (enter para manter '" + f.getOrcamento() + "'): ");
        if (!oStr.isEmpty()) f.setOrcamento(Double.parseDouble(oStr));

        String desc = lerTexto("Nova descrição (enter para manter): ");
        if (!desc.isEmpty()) f.setDescricao(desc);

        String dNome = lerTexto("Novo diretor (enter para manter '" + (f.getDiretor() != null ? f.getDiretor().getNome() : "Nenhum") + "'): ");
        if (!dNome.isEmpty()) {
            Diretor d = buscarOuCriarDiretor(dNome);
            f.setDiretor(d);
        }
        System.out.println("Filme atualizado.");
    }

    public void removerFilme() {
        int i = pedirIndice(filmes, "filme", false);
        if (i == -1) return;

        filmes.remove(i);
        System.out.println("Filme removido.");
    }

    public void buscarFilme() {
        String titulo = lerTexto("Título para buscar: ");
        List<Filme> encontrados = new ArrayList<>();
        for (Filme f : filmes) {
            if (f.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(f);
            }
        }
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esse título.");
        } else {
            listar(encontrados, "filme encontrado");
        }
    }

    public void cadastrarAtor() {
        String nome = lerTexto("Nome do ator: ");
        atores.add(new Ator(nome));
        System.out.println("Ator cadastrado.");
    }

    public void listarAtores() {
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }
        listar(atores, "ator");
    }

    public void editarAtor() {
        int i = pedirIndice(atores, "ator", false);
        if (i == -1) return;

        Ator a = atores.get(i);
        String nome = lerTexto("Novo nome do ator (enter para manter '" + a.getNome() + "'): ");
        if (!nome.isEmpty()) {
            a.setNome(nome);
            System.out.println("Ator atualizado.");
        } else {
            System.out.println("Nome mantido.");
        }
    }

    public void removerAtor() {
        int i = pedirIndice(atores, "ator", false);
        if (i == -1) return;

        Ator a = atores.get(i);
        filmes.forEach(f -> f.getAtores().remove(a));
        atores.remove(i);
        System.out.println("Ator removido.");
    }

    public void associarAtorFilme() {
        if (filmes.isEmpty() || atores.isEmpty()) {
            System.out.println("Cadastre filmes e atores antes.");
            return;
        }
        int iF = pedirIndice(filmes, "filme", false);
        if (iF == -1) return;
        int iA = pedirIndice(atores, "ator", false);
        if (iA == -1) return;

        Filme f = filmes.get(iF);
        Ator a = atores.get(iA);

        if (f.getAtores().contains(a)) {
            System.out.println("Ator já associado.");
        } else {
            f.getAtores().add(a);
            System.out.println("Ator associado.");
        }
    }

    public void cadastrarDiretor() {
        String nome = lerTexto("Nome do diretor: ");
        diretores.add(new Diretor(nome));
        System.out.println("Diretor cadastrado.");
    }

    public void listarDiretores() {
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        listar(diretores, "diretor");
    }

    public void editarDiretor() {
        int i = pedirIndice(diretores, "diretor", false);
        if (i == -1) return;

        Diretor d = diretores.get(i);
        String nome = lerTexto("Novo nome do diretor (enter para manter '" + d.getNome() + "'): ");
        if (!nome.isEmpty()) {
            d.setNome(nome);
            System.out.println("Diretor atualizado.");
        } else {
            System.out.println("Nome mantido.");
        }
    }

    public void removerDiretor() {
        int i = pedirIndice(diretores, "diretor", false);
        if (i == -1) return;

        Diretor d = diretores.get(i);
        filmes.forEach(f -> {
            if (f.getDiretor()!= null && f.getDiretor().equals(d)){
                f.setDiretor(null);
            }
        });
        diretores.remove(i);
        System.out.println("Diretor removido.");
    }

    public void associarDiretorFilme() {
        if (filmes.isEmpty() || diretores.isEmpty()) {
            System.out.println("Cadastre filmes e diretores antes.");
            return;
        }
        int iF =pedirIndice(filmes, "filme", false);
        if (iF == -1) return;
        int iD = pedirIndice(diretores, "diretor", false);
        if (iD == -1) return;

        Filme f =filmes.get(iF);
        Diretor d =diretores.get(iD);
        f.setDiretor(null);
        System.out.println("Diretor associado.");
    }

    private Diretor buscarOuCriarDiretor(String nome) {
        for (Diretor d : diretores) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        Diretor novo = new Diretor(nome);
        diretores.add(novo);
        System.out.println("Diretor cadastrado automaticamente.");
        return novo;
    }
}



