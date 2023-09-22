import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PF04CustomClass_G {

    //Big number calculations using BingInteger
    public static void main(String[] args) {
      //  Integer.MAX_VALUE;
        //Long.MAX_VALUE;

        System.out.println(
        IntStream.rangeClosed(1,10).reduce(1,(x,y)->x*y)
            );

        System.out.println(
        LongStream.rangeClosed(1,50).reduce(1,(x,y)->x*y)
        );

        System.out.println(
                LongStream.rangeClosed(1,50).reduce(1L,(x,y)->x*y)
        );

        System.out.println(
        LongStream.rangeClosed(1,25).reduce(1,(x,y)->x*y)
        );
        System.out.println("****");

        //Work with big numbers
        System.out.println(
        LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply)
        );
    }
}
