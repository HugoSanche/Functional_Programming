import java.util.List;

public class FP03MethodReferences {
    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");
        courses.stream()

                //.map(s->s.toUpperCase())
                .map(String::toUpperCase)

                //.forEach(s-> System.out.println(s));
                .forEach(System.out::println);
    }
}
