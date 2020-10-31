package varargs;

public class ApplicationVarargs {
    public static void main(String[] args) {
        Varargs varargs = new Varargs();
        int [] numeros = {1,2,3,4,5};

        varargs.somaArray(numeros);
        varargs.somaVarargs(numeros);
    }
}
