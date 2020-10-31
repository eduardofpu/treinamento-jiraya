package abstrato;

public class Gerente extends Funcionario{

    public Gerente(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public void calcularSalario() {
        this.salario = salario * 1.7;
    }

    public void imprimirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Salario: " + this.salario);
    }
}
