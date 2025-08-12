
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
}


