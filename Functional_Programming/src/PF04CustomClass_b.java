import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PF04CustomClass_b {
    public static void main(String[] args) {
        List<Course> courses =List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",94,14000),
                new Course("AWS","Cloud",100,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
        );

        Comparator<Course> comparingByNoStudentsAndReviewScore=Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        Predicate<Course> reviewScoreLessThan90Predicate= course->course.getReviewScore()<90;

        Predicate<Course> reviewScoreGreaterThan95Predicate=course -> course.getReviewScore()>95;

        System.out.println(
                courses.stream().sorted(comparingByNoStudentsAndReviewScore)
                .collect(Collectors.toList()));

        System.out.println("MAX");
        System.out.println(
            courses.stream()
                    .max(comparingByNoStudentsAndReviewScore)
        );

        System.out.println("MIN");
        System.out.println(
                courses.stream()
                        .min(comparingByNoStudentsAndReviewScore)
                        .orElse(new Course("Kubernetes","Cloud",91,20000))//not print
        );


        System.out.println("OrElse");
        System.out.println(
        courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoStudentsAndReviewScore)
                //empty
                .orElse( new Course("Kubernetes","Cloud",91,20000)) //return this course
                //because the last result is empty
        );


        System.out.println("findFirst()");
        System.out.println(
        courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .findFirst()
        );
        //Optional.empty

        System.out.println(
            courses.stream()
                    .filter(reviewScoreGreaterThan95Predicate)
                  .findFirst()
        );
        //Optional[Spring:20000:98]
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate).findAny()
        );
        //Optional[Spring:20000:98]
    }
}
