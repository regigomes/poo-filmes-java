import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n ===== Catalogo de filmes =====");
            System.out.println("\n ------FILMES------");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Listar Filme");
            System.out.println("3 - Editar Filme");
            System.out.println("4 - Remover Filme");
            System.out.println("5 - Buscar Filme por Título");

            System.out.println("\n ------ATORES------");
            System.out.println("6  -  Cadastrar Ator");
            System.out.println("7  -  Listar Atores");
            System.out.println("8  -  Editar Ator");
            System.out.println("9  -  Remover Ator");
            System.out.println("10 -  Associar Ator a Filme");

            System.out.println("\n--------DIRETORES------");
            System.out.println("11 -  Cadastrar Diretor");
            System.out.println("12 -  Listar Diretores");
            System.out.println("13 -  Editar Diretor");
            System.out.println("14 -  Remover Diretor");
            System.out.println("15 -  Associar Diretor a Filme");

            System.out.println("\n0 - Sair");
            System.out.println("Digite opcao: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1 -> catalogo.cadastrarFilme();
                case 2 -> catalogo.listarFilmes();
                case 3 -> catalogo.editarFilme();
                case 4 -> catalogo.removerFilme();
                case 5 -> catalogo.buscarFilme();
                case 6 -> catalogo.cadastrarAtor();
                case 7 -> catalogo.listarAtores();
                case 8 -> catalogo.editarAtor();
                case 9 -> catalogo.removerAtor();
                case 10 -> catalogo.associarAtorFilme();
                case 11 -> catalogo.cadastrarDiretor();
                case 12 -> catalogo.listarDiretores();
                case 13 -> catalogo.editarDiretor();
                case 14 -> catalogo.removerDiretor();
                case 15 -> catalogo.associarDiretorFilme();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }

        }while (opcao != 0);

    }
}



