package colections;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Has não ordena a lista
 **/
@Configuration
public class HasMap {

    @Value("${key.id}")
    public static String keyId;

    public static void Map(){

        /** Chave e Valor **/
        Map<String, String> map = new HashMap<>();
        map.put("Teklado", "Teclado");
        map.put("titan", "Titan");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        map.put("vc", "voce");
        map.put("meza", "mesa");
        map.put("id", keyId);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

public static void main(String[] args) {
       Map();
    }
}
