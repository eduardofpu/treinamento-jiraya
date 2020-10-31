package statico;

public class Carro {
    public String carro;
    public static int velocidade;


    public Carro(String carro, int velocidade) {
        this.carro = carro;
        this.velocidade = velocidade;
    }

    public Carro() {
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public static int getVelocidade() {
        return velocidade;
    }

    public static void setVelocidade(int velocidade) {
       Carro.velocidade = velocidade;
    }

    public void imprimir() {
        System.out.println("Nome: " + this.carro);
        System.out.println("Velocidade limite: " + velocidade);
    }


}
