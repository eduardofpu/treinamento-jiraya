package colections.celular;

import java.util.Objects;

public class Celular {
    private String nome;
    private String imei;


    public String getNome() {
        return nome;
    }

    public Celular() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Celular(String nome, String imei) {
        this.nome = nome;
        this.imei = imei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celular celular = (Celular) o;
        return Objects.equals(nome, celular.nome) &&
                Objects.equals(imei, celular.imei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, imei);
    }

    @Override
    public String toString() {
        return "Celular{" +
                "nome='" + nome + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
