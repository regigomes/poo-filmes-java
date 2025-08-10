// Diretor herda da classe abstrata Pessoa
// A classe Diretor não precisa de atributos adicionais, pois herda de Pessoa
public class Diretor extends Pessoa { // A palavra 'extends' indica que Diretor herda de Pessoa
    public Diretor(String nome, String dataNascimento) {
        super(nome, dataNascimento);
    } // Essa classe também não precisa de atributos adicionais
}
