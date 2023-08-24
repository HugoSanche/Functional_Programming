import java.util.List;

public class PF02Functional {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(10,12,8,15,18,9,17,6,5,10);
        int sum=addListFunctional(numbers);

        sum=numbers.stream().reduce(Integer.MAX_VALUE,(x,y)->x>y ? y:x);
        numbers.stream().map(number->number*number).reduce(0,(a,b)->a+b);

        System.out.println(sum);
    }
    private static int sum(int aggregate, int nextNumber){
        System.out.println(aggregate+" "+nextNumber);
        return aggregate+nextNumber;
    }
    public static int addListFunctional(List<Integer> numbers){
        //Stream of number -> One result Value
        //Combine them into one result => one value
        // 0 and PF02Functional::sum
       return numbers.stream().
              //  reduce(0,PF02Functional::sum);
              //  reduce(0,(a,b)->a+b); //using lambda expression
              reduce(0,Integer::sum); //using method reference
    }
}
