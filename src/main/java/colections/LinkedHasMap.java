package colections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** Mantem a ordem de inserão **/
public class LinkedHasMap {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("Teklado", "Teclado");
        map.put("titan", "Titan");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        map.put("meza", "mesa");


        for (String key : map.values()) {
            System.out.println(key);
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }

    }
}
