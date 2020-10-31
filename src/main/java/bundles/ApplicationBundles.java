package bundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationBundles {
    public static void main(String[] args) {
//        Linguagem default
        System.out.println(Locale.getDefault());

        ResourceBundle rb = ResourceBundle.getBundle("messages",new Locale("en","US"));
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("good.morning"));
        System.out.println(rb.getString("show"));
        System.out.println(rb.getString("video"));

        rb = ResourceBundle.getBundle("messages",new Locale("pt","BR"));
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("good.morning"));
        System.out.println(rb.getString("show"));
        System.out.println(rb.getString("video"));



    }
}
