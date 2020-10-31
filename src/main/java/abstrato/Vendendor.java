package abstrato;

public class Vendendor extends Funcionario {

    public Vendendor(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public void calcularSalario() {
        this.salario = salario * 1.5;
    }

    public void imprimirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Salario: " + this.salario);
    }
}
