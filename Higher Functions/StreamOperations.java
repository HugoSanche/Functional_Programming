import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

public class StreamOperations {
    public static void main(String[] Args){
        List<Double> lista =Arrays.asList(253.2, 10.9,75.6,800.2,67.4,741.6,360.0,509.6,900.14,150.5,340.0);
        lista.stream().filter(x->{
            return x>500;
        }).map(price->{
            return price +20; 
        }).sorted((left, right)->{
            return left.compareTo(right);
        }).map(price->{
            return "$" + price;
        }).
        forEach(i->{
            System.out.println(i);        
        });
    
    }
}
