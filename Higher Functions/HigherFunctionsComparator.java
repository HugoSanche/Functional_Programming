import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HigherFunctionsComparator {
    public static void main (String[] Args){
        List<Integer> myList =Arrays.asList(50,12,49,1,24,71,26);
        
        myList.sort((left, right)->{
                return right.compareTo(left);
        });

        System.out.println(myList);
    }
}
