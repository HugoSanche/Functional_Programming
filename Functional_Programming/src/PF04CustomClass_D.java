import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PF04CustomClass_D {
    public static void main(String[] args) {
        List<Course> courses =List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",94,14000),
                new Course("FullStack","JAVA",94,10000),
                new Course("AWS","Cloud",100,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
        );
        System.out.println(
        courses.stream().collect(Collectors.groupingBy(Course::getCategory))
        );
        //{Cloud=[AWS:21000:100, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:94], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
        );
       // {Cloud=4, FullStack=1, Microservices=2, Framework=2}

        //Me agrupa por categoria y de esa agrupacion me trae el de mayor score
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );
        //{Cloud=Optional[AWS:21000:100], FullStack=Optional[FullStack:14000:94], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

       //Agrupa por categoria y trae solamente el nombre
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList())))
        );
       //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}



        System.out.println("Exercises");
        //exercises
        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getName))
        );

        //
        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                         Collectors.maxBy(Comparator.comparing(Course::getNoOfStudents))))
        );

        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.counting()))
        );

        System.out.println(
        courses.stream().collect(Collectors.groupingBy(Course::getName,Collectors.mapping(Course::getName,Collectors.toList())))
        );


        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.maxBy(Comparator.comparing(Course::getNoOfStudents))
        )));

    }
}
