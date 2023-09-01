import java.util.Comparator;
import java.util.List;

public class FPExercises {
    public static void main(String[] args) {
        //exercises one
        printOddNumbersInListFunctional(List.of(10,12,8,15,18,9,17,6,5,10));
        System.out.println("-----------------");

        //Exercises two
        List<String> courses=List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");
        printAllCourses(courses);

        System.out.println("-----------------");
        //Exercises three
        printFilterCourses(courses);

        System.out.println("-----------------");
        //Exercises four
        printOnly4Letters(courses);

        System.out.println("-----------------");
        //Test
        //print the course >=4
        courses.stream().filter(str -> str.matches("\\w{4,}")).forEach(System.out::println);

        System.out.println("-----------------");
        //Exercises five
        printSquaresNumbersInListFunctional(List.of(10,12,8,15,18,9,17,6,5,10));

        System.out.println("-----------------");
        //Exercises six
        printOddCubesNumbersInListFunctional(List.of(10,12,8,15,18,9,17,6,5,10));

        System.out.println("-----------------");
        //Exercises six
        courses.stream().
            map(course->course.length()).forEach(System.out::println);

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparing(str->str.length())).forEach(System.out::println);

    }
    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        //numbers.stream().forEach(FP01Structured::print);
        // numbers.stream().forEach(System.out::println);
        numbers.stream().
                filter(number -> number % 2 == 1)
                .forEach(System.out::println);
    }
    public static void printAllCourses(List<String> list){
        list.stream().
                forEach(System.out::println);
    }
    public static void printFilterCourses(List<String> list){
        list.stream().
                filter(course->course.contains("Spring")).
                forEach(System.out::println);
    }
    public static void printOnly4Letters(List<String> list){
        list.stream().
                filter(course->course.length()>=4).
                forEach(System.out::println);
    }
    public static void printSquaresNumbersInListFunctional(List<Integer> list){
        list.stream().
                filter(course->course%2==0).
                map(number->number*number).
                forEach(System.out::println);
    }
    private static void printOddCubesNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().
                filter(number -> number % 2 == 1)
                .map(number->number*number*number)
                .forEach(System.out::println);
    }
}
