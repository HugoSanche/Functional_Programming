import java.util.List;

public class PerformanceLambdaExpression {
    public static void main(String[] args) {
        List<String> courses= List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");
        System.out.println(

        //itera hasta encontrar el PRIMER valor >11 y despues lo convierte a Mayusculas
        courses.stream()
                .peek(System.out::println)
                .filter(course->course.length()>11)
                .map(x->x.toUpperCase())
                .peek(System.out::println)
                .findFirst() //operation determinate
            );
    }
}
