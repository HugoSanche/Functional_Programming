import java.util.stream.Collectors;
import java.util.stream.IntStream;

//IntStream.range()
//IntStream.iterate
public class PF04CustomClass_F {
    public static void main(String[] args) {
        //not add the sum of number 10
        System.out.println(
        IntStream.range(1,10).sum()
        );

        System.out.println(
        //this aggregate the number 10
        IntStream.rangeClosed(1,10).sum()
        );

        //boxed() = cast the number primitive to Integer
        System.out.println(
        IntStream.iterate(1,a->a*2).limit(10).boxed().collect(Collectors.toList())
        );

        System.out.println("******");
        IntStream.iterate(1,a->a*2).limit(10).peek(System.out::println).sum();

    }
}
