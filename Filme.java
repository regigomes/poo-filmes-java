
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private String dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String titulo, String dataLancamento, double orcamento, String descricao) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.atores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    @Override
    public String toString() {
        return String.format(
                "%s (%s) - Diretor: %s\nOrçamento: R$ %.2f\nDescrição: %s\nAtores: %s",
                titulo, dataLancamento,
                diretor != null ? diretor.getNome() : "Nenhum",
                orcamento, descricao, atores
        );
    }
}