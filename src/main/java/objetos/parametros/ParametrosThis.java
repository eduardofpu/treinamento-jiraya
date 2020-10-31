package objetos.parametros;
/** Referenciando os objetos com o this para aproveitar memória  Aula 32 Dev Dojo**/
public class ParametrosThis {

    public String nome;
    public String cpf;
    public int idade;

    public void imprime() {
        System.out.println("Nome: " + this.nome);
        System.out.println("cpf: " + this.cpf);
        System.out.println("idade: " + this.idade + " anos");
    }
}
