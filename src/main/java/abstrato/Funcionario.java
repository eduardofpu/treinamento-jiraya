package abstrato;

/** Metodos abstract nao precisam de implementação **/
public abstract class Funcionario {
    protected String nome;
    protected double salario;

    public abstract void calcularSalario();

    public abstract void imprimirFuncionario();
}
