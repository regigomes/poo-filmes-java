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
}