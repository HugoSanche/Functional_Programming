import java.util.HashMap;
import java.util.Map;

public class HigherFunctionsBiConsumer {
    public static void main (String[] Args){
    Map<String, Integer> coffeRatings =new HashMap<>();
    coffeRatings.put("Starbuck House Blend", 7);
    coffeRatings.put("Bienvenido a sucursal Ecatepec", 8);
    coffeRatings.put("Americano", 9);
    coffeRatings.put("Capuchino", 7);
    coffeRatings.forEach((key,value)->{
        System.out.println("Coffe "+key+" Rating "+value);
    });
    }

}
