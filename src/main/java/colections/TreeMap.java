package colections;
import java.util.Map;
import java.util.NavigableMap;

/** Quando for prciso utilizar o comparator.   Obs: as String   já utilizam o comparator **/
public class TreeMap {
    public static void main(String[] args) {

        NavigableMap<String, String> map = new java.util.TreeMap<>();
        map.put("A","LETRA: A");
        map.put("D","LETRA: D");
        map.put("B","LETRA: B");
        map.put("E","LETRA: E");
        map.put("C","LETRA: C");

        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        System.out.println("---------------------------");

        /** retorna os id < que C **/
        System.out.println(map.headMap("C"));

        /** retorna os id <= C **/
        System.out.println(map.headMap("C", true));

        /** retorna os id < C **/
        System.out.println(map.headMap("C", false));

        /** retorna o primeiro id > C **/
        System.out.println(map.higherEntry("C"));

        /** retorna os id ivertidos **/
        System.out.println(map.descendingMap());
    }
}
