import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        printEvenNumbersInListFunctional(List.of(10,12,8,15,18,9,17,6,5,10));



    }



    //  public static void print(int number){
  //      System.out.println(number);
  //  }
//    public static boolean isEven(int number){
//        return number%2==0;
//    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //numbers.stream().forEach(FP01Structured::print);
        numbers.stream().forEach(System.out::println);

    }
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //numbers.stream().forEach(FP01Structured::print);
        // numbers.stream().forEach(System.out::println);
        numbers.stream().
                filter(number->number%2==0)
                .forEach(System.out::println);

//       .filter(FP01Functional::isEven)
//        numbers.stream().forEach(n -> {
//            if (n % 2 == 0) {
//                System.out.println(n);
//            }
//        });
    }
}
