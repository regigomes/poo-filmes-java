// classe pessoa java 
/**
 * Classe abstrata que representa uma pessoa genérica no sistema.
 * Serve como base para diferentes tipos de pessoas 
 */
public abstract class Pessoa { // Classe abstrata que não pode ser instanciada diretamente
    // Atributos comuns a todas as pessoas
    /** Nome completo da pessoa */
    private String nome;

    /**
     * Construtor que inicializa uma nova pessoa.
     * @param nome Nome completo da pessoa
     * @param dataNascimento Data de nascimento no formato dd/mm/aaaa
     */
    public Pessoa(String nome, String dataNascimento) { // Construtor que recebe nome e data de nascimento
        // Inicializa os atributos da pessoa
        this.nome = nome;
    }

    /**
     * Retorna o nome da pessoa.
     * @return String contendo o nome completo
     */
    public String getNome() { // Método para obter o nome da pessoa
        // Retorna o nome completo da pessoa
        return nome;
    }

    /**
     * Retorna a data de nascimento da pessoa.
     * @return String contendo a data no formato dd/mm/aaaa
     */
}
