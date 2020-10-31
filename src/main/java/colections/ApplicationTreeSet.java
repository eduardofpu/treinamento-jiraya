package colections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import colections.celular.Celular;
import colections.produto.Produto;

class CeluarComparator implements Comparator<Celular>{

    @Override
    public int compare(Celular o1, Celular o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
public class ApplicationTreeSet {
    public static void main(String[] args) {
        Produto produto1 = new Produto("10","CELULAR","LG","1800");
        Produto produto2 = new Produto("20","CELULAR","IOS","4500");
        Produto produto3 = new Produto("30","CELULAR","SONYC","2800");
        Produto produto4 = new Produto("40","CELULAR","SAMSUNG","3800");
        Produto produto5 = new Produto("50","CELULAR","MOTOROLA","800");

        /**  Ele não iseri elementos repetidos  e mantem a lista ordenada **/
        /** Possui índice **/
        Produto produto6= new Produto("50","CELULAR","MOTOROLA","800");

        Celular celular = new Celular("ASUS","M123");

        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();

        /** Para usar o TreeSet e preciso criar uma classe comparator para o celular **/
        /** Os elementos são ordenados automaticamente  Atenção: a performace não e muito eficiente **/
        NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CeluarComparator());

        celularNavigableSet.add(celular);

        /**  Verificar aqui **/
        for (Celular c : celularNavigableSet){
            System.out.println(c);
        }
    }
}
