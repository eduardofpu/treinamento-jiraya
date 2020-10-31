package abstrato;

public class ApplicationSalario {
    public static void main(String[] args) {

        System.out.println("------- Salario do Vendedor ------");

        Vendendor vendendor = new Vendendor("Marcos", 1000);
        vendendor.calcularSalario();
        vendendor.imprimirFuncionario();

        System.out.println("------- Salario do Gerente ------");

        Gerente gerente = new Gerente("Gilberto", 1000);
        gerente.calcularSalario();
        gerente.imprimirFuncionario();
    }
}
