import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(10,12,8,15,18,9,17,6,5,10,-3);

        //Predicate
        Predicate<Integer> predicateNumber=new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number>10;
            }
        };
       // numbers.stream().filter(predicateNumber).forEach(System.out::println); //LAMBDA

       //numbers.stream().filter(number->number>10).forEach(System.out::println);

        /***********************************************/
        //Function

        //numbers.stream().map(number->number*2).forEach(System.out::println);//LAMBDA
        Function<Integer,Double> multiplyNumber= new Function<Integer,Double>() {
            @Override
            public Double apply(Integer o) {
                return o*1.1;
            }
        };
      //  numbers.stream().map(multiplyNumber).forEach(System.out::println);

        /***********************************************/
        //Consumer
        //numbers.stream().forEach(System.out::println); //LAMBDA
        Consumer<Integer> consumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

      //  numbers.stream().forEach(consumer);

        /***********************************************/
        //BINARY OPERATOR

        System.out.println(
                numbers.stream().reduce(0,(number1,number2)->number1+number2)
        );//LAMBDA
        BinaryOperator<Integer> binaryOperator=new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer number1, Integer number2) {
                return number1+number2;
            }
        };
        System.out.println(
        numbers.stream().reduce(0,binaryOperator)
       );
        /***********************************************/
        //SUPPLIER
        System.out.println("SUPPLIER");
        Supplier<Integer> supplier=new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random ramdomNumber=new Random();
                return ramdomNumber.nextInt(100);

            }
        };
        System.out.println(supplier.get());
    }
}
