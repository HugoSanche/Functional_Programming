import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PF04CustomClass_H {
    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azure","Dockers","Kubernetes");

        System.out.println(
        courses.stream().collect(Collectors.joining(" "))
        );

        System.out.println(
            courses.stream().collect(Collectors.joining(", "))
        );

        System.out.println(
        "Spring".split("")
        );

        System.out.println(
        courses.stream().map(course->course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
        );


        System.out.println(
        courses.stream().map(course->course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
        );

        List<String> courses_One=List.of("Spring1","Spring boot1","API1","Microservices1","AWS1","PCF1","Azure1","Docker1","Kubernetes1");

        List<String> courses_Two=List.of("Spring2","Spring boot2","API2","Microservices2","AWS2","PCF2","Azure2","Docker2","Kubernetes2");

        System.out.println();
        System.out.println("FIRST");
        System.out.println(
        courses_One.stream()
                .flatMap(course_1 ->courses_Two
                        .stream()
                        .map(course_2->List.of(course_1,course_2)))
                .collect(Collectors.toList())
            );

        System.out.println();
        System.out.println("SECOND");
        System.out.println(
        courses_One.stream()
                .flatMap(course_1->courses_Two
                        .stream()
                        .map(course_2->List.of(course_1,course_2)))
                .filter(list->list.get(0)
                        .equals(list.get(1)))
                .collect(Collectors.toList())
        );

        System.out.println();
        System.out.println("THIRD");
        System.out.println(
        courses_One.stream()
                .flatMap(course_1->courses_Two
                        .stream()
                        .map(course_2->List.of(course_1,course_2)))
                .filter(list->!list.get(0)
                        .equals(list.get(1)))
                .collect(Collectors.toList())
        );

        System.out.println();
        System.out.println("FOUR");
        System.out.println(
                courses_One.stream()
                        .flatMap(course_1->courses_Two
                                .stream()
                                .filter(course_2->course_2.length()==course_1.length())
                                .map(course_2->List.of(course_1,course_2)))
                        .filter(list->!list.get(0)
                                .equals(list.get(1)))
                        .collect(Collectors.toList())
        );

        System.out.println();
        System.out.println("FIVE");
        System.out.println(
                courses_One.stream()
                        .flatMap(course_1->courses_Two
                                .stream()
                                .filter(course_2x->course_2x.length()==course_1.length())
                                .filter(course_2y->course_2y.length()==4)
                                .map(course_2->List.of(course_1,course_2)))
//                        .filter(list->!list.get(0)
//                                .equals(list.get(1)))
                        .collect(Collectors.toList())
        );
        System.out.println(
        courses_One.stream().
                flatMap(course_1->courses_Two
                .stream()
                .filter(course_2x->course_2x.length()==course_1.length())
                .filter(course_2y->course_2y.length()==4)
                .map(course_2->List.of(course_1,course_2)))
                .collect(Collectors.toList())
                );
    }
}













