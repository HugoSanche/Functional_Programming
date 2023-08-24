import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        printEvenNumbersInListStructured(List.of(10,12,8,15,18,9,17,6,5,10));
    }
public static void print(int number){
    System.out.println(number);
}
    private static void printAllNumbersInListStructured(List<Integer> numbers) {
       for(int number:numbers){
           System.out.println(number);
        }
    }
    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for(int number:numbers){
            if(number%2==0){
                System.out.println(number);
            }
        }
    }
}
