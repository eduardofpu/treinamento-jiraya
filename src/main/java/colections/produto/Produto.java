package colections.produto;

import java.util.Objects;

public class Produto {
    private String id;
    private String nome;
    private String marca;
    private String valor;

    public Produto() {
    }

    public Produto(String id, String nome, String marca, String valor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(marca, produto.marca) &&
                Objects.equals(valor, produto.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, marca, valor);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
