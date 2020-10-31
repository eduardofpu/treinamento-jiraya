package colections;

import java.util.LinkedHashSet;
import java.util.Set;

import colections.produto.Produto;

/**Principal caracteristica do LinkedHashSet:  Ele não iseri elementos repetidos  e mantem a lista ordenada **/
public class LinkedSet {
    public static void main(String[] args) {
        Produto produto1 = new Produto("10","CELULAR","LG","1800");
        Produto produto2 = new Produto("20","CELULAR","IOS","4500");
        Produto produto3 = new Produto("30","CELULAR","SONYC","2800");
        Produto produto4 = new Produto("40","CELULAR","SAMSUNG","3800");
        Produto produto5 = new Produto("50","CELULAR","MOTOROLA","800");

        /**  Ele não iseri elementos repetidos  e mantem a lista ordenada **/
        /** Possui índice **/
        Produto produto6= new Produto("50","CELULAR","MOTOROLA","800");

        Set<Produto> produtoSet = new LinkedHashSet<>();
        produtoSet.add(produto1);
        produtoSet.add(produto2);
        produtoSet.add(produto3);
        produtoSet.add(produto4);
        produtoSet.add(produto5);

        /**  Ele não iseri elementos repetidos **/
        produtoSet.add(produto6);

        /**  Verificar aqui **/
        for (Produto p : produtoSet){
            System.out.println(p);
        }
    }
}
