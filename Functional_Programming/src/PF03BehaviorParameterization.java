import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PF03BehaviorParameterization {
    /*
    boolean isEven(int x){
        return x%2==00;
    }
    int square(int x){
        return x*x;
    }
    *
    * */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
/*
        numbers.stream()
                .filter(x->x%2==0)
                .forEach(System.out::println);

        numbers.stream()
                .filter(x->x%2!=0)
                .forEach(System.out::println);
*/
        //CHECK HOW PARAMETERIZATION REDUCE CODE AND MORE FLEXIBLE

        //Example predicate
      // filterAndPrint(numbers,x->x%2==0);
       // filterAndPrint(numbers,x->x%2!=0);

        //Example Function
        //Exercise number 13
        List<Integer> squareNumbers=operation(numbers,x->x*x);
        List<Integer> cubeNumbers=operation(numbers,x->x*x*x);
        List<Integer> doubleNumbers=operation(numbers,x->x+x);

        System.out.println(squareNumbers);
    }
    public static void filterAndPrint(List<Integer> list, Predicate<Integer> predicate){
        list.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
    public static List<Integer> operation(List<Integer> list, Function<Integer,Integer> function){
        List<Integer>result=list.stream()
                .map(function)
                .collect(Collectors.toList());
        return result;
    }

}
