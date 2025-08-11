import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private int ano;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.atores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

    public String toString() {
        return titulo + " (" + ano + ") - Diretor: " + (diretor != null ? diretor.getNome() : "Nenhum") + ", Atores: " + atores ;
    }
}