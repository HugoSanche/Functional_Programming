import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PF02Functional {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(10,12,8,15,18,9,17,6,5,10,-3);
        int sum=addListFunctional(numbers);

        sum=numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->a<b? a:b);
        numbers.stream().map(number->number*number).reduce(0,(a,b)->a+b);
        System.out.println(sum);

        System.out.println("**************************************************");
        List<Integer> doubleNumbers=doubleList(numbers);
        System.out.println(doubleNumbers);

        List<Integer>result= numbers
                .stream()
                .filter(a->a%2==0)
                .collect(Collectors.toList());
        System.out.println(result);

        List<String> courses=List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");

        courses
                .stream()
                .distinct()//Stream<T> Intermediate
                .sorted(Comparator.naturalOrder())////Stream<T>
                .forEach(System.out::println);//void

        List<Integer>lenghtCourses=courses
                .stream()
                .map(a->a.length())//Stream<T>
                .collect(Collectors.toList());//R
        System.out.println(lenghtCourses);

        numbers
                .stream()
                .reduce(Integer.MIN_VALUE,Integer::sum);//T

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
              reduce(Integer.MIN_VALUE,Integer::sum); //using method reference //T
    }
    private static List<Integer> doubleList(List<Integer> numbers) {
        List<Integer> result=numbers.stream().map(a->a*a).collect(Collectors.toList());
        return result;
    }
}
