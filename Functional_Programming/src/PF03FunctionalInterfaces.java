import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class PF03FunctionalInterfaces {
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
        List<Integer> numbers=List.of(12,9,13,4,6,2,4,12,15);

        System.out.println("PREDICATE");
        /*PREDICATE.- Received one argument and return a boolean*/
        Predicate<Integer> isEvenPredicate =  x -> x % 2 == 0;

        //functional interfaces.- only have one abstract method
        Predicate<Integer> isEvenPredicate2 =  new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        numbers.stream().filter(number->number>10).forEach(System.out::println);

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("FUNCTION");
        /*FUNCTION.-Received one argument a return a value it's the second parameter */
        Function<Integer, Integer> squareFunction = x -> x * x;

        //Function interface
        Function<Integer, Integer> squareFunction2 =new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        System.out.println(
        numbers.stream().map(x->x+2).collect(Collectors.toList())
        );

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("CONSUMER");
        /*
        * CONSUMER.- Received one argument and don't return anything
        * */
        Consumer<Integer> sysoutConsumer=System.out::println;

        //Function interface
        Consumer<Integer> sysoutConsumer2=new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers
                .stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("BINARY-OPERATOR");
        //Exercise 12;
        /*
        * BINARYOPERATOR.- Received 2 arguments and return one value
        * */
        BinaryOperator<Integer> sumBinaryOperator=Integer::sum;

        //function Interface
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x+y;
            }
        };
        System.out.println("REDUCE");
        System.out.println(
        numbers
                .stream()
                .reduce(0, sumBinaryOperator2)
        );


        BinaryOperator<String> result=(string1, string2)->{
            return string1+string2;
        };
        System.out.println(result.apply("Hola ","mundo"));

        //System.out.println(numbers);

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("SUPPLIER");
        /*
        * SUPPLIER.- No arguments return something
        * */
        //No input > Return something

        Supplier<Integer> ramdomIntegerSupplier=()->{
            Random random=new Random();
            return random.nextInt(1000);
        };
        Supplier<String> string=()->{
          return "Hugo Baltazar";
        };
        System.out.println(ramdomIntegerSupplier.get());
        System.out.println(string.get());

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("UNARY OPERATOR");
        /*
         * UNARY OPERATOR.- 1 argument return something
         * */
        UnaryOperator<Integer> unaryOperator=x->3+x;
        System.out.println(unaryOperator.apply(35));

        /*
        * Difference between Function & UnaryOperator
        *
        * Function can have a different type of input and output. UnaryOperator should have the same type.
        * */

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("BIPREDICATE");
        /*
         * BIPREDICATE.- two arguments return boolean
         * */
        BiPredicate<Integer, String> biPredicate=(number, str)-> {
          return  number>10 &&  str.length()>5;
        };
        System.out.println(biPredicate.test(10,"Hugo"));

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("BIFUNCTION");
        /*
         * BIFUNCTION.- THREE arguments, the LAST ARGUMENT it's the type argument return
         * */

        //one example.- return boolean
        BiFunction<Integer,String,Boolean> biFunction=(number,str)->{
            return  number>10 &&  str.length()>5;
        };

        //two example.- return string
        BiFunction<Integer,String,String> biFunction2=(number,str)->{
            return  number+" "+str;
        };

        System.out.println(biFunction.apply(15,"Hugo"));
        System.out.println(biFunction2.apply(15,"Hugo"));

        /*---------------------------------------------------------------------------------------------------------*/
        System.out.println("IntBinaryOperator");
        /*
         * IntBinaryOperator.- 2 arguments, the LAST n
         * */


        IntBinaryOperator intBinaryOperator=(primitiveNumber,primitiveNumber2)->primitiveNumber+primitiveNumber2;
        System.out.println(intBinaryOperator.applyAsInt(10,10));

        /*
        Next functional interfaces it's used to work with primitive types
        */
        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator
    }
}











