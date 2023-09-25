import java.util.ArrayList;
import java.util.List;

public class PF04CustomClass_I {
    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");

        List<String> modifyableCourses=new ArrayList<>(courses);

        modifyableCourses.replaceAll(str->str.toUpperCase());
        System.out.println(modifyableCourses);

        System.out.println(
        modifyableCourses.removeIf(str->str.length()>6)
        );
        System.out.println(modifyableCourses);


    }
}
