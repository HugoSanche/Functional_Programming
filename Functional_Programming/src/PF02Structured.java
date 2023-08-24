import java.util.List;

public class PF02Structured {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(10,12,8,15,18,9,17,6,5,10);
        int sum=addListStructured(numbers);
        System.out.println(sum);
    }
    public static int addListStructured(List<Integer> numbers){
        int sum=0;
        for(int number:numbers){
            sum+=number;
        }
        return sum;
    }
}
