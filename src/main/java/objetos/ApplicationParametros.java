package objetos;

import objetos.parametros.ParametrosThis;

public class ApplicationParametros {
    public static void main(String[] args) {

        ParametrosThis parametros = new ParametrosThis();
        parametros.nome = "Eduardo";
        parametros.cpf = "11111111111";
        parametros.idade = 40;
        parametros.imprime();

    }
}
