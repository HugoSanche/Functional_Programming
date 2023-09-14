import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PF04CustomClass {
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

        //allMatch, none Match, AnyMatch
        Predicate<Course> reviewScoreGraterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGraterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        //All match
        System.out.println("ALL MATCH");
        System.out.println(
        courses.stream().allMatch(reviewScoreGraterThan95Predicate));


        System.out.println("NONE MATCH");
        //None Match
        System.out.println(
                courses.stream().noneMatch(reviewScoreGraterThan90Predicate));
        System.out.println(
                courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println("ANY MATCH");
        // AnyMatch
        System.out.println(
                courses.stream().anyMatch(reviewScoreGraterThan90Predicate));
        System.out.println(
                courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        //Sorting Courses with comparator
        System.out.println("Working with comparator");

                                     //REMEMBER for primitives its better using comparingInt not used unboxing
        Comparator<Course> comparingByNoOfStudentsIncreasing=Comparator.comparingInt(Course::getNoOfStudents);
        System.out.println(
                        courses.stream()
                                .sorted(comparingByNoOfStudentsIncreasing)
                                .collect(Collectors.toList())
                    );

        Comparator<Course> comparingByNoStudentsDecreasing=Comparator.comparingInt(Course::getNoOfStudents).reversed();

        System.out.println(
                        courses.stream()
                                .sorted(comparingByNoStudentsDecreasing)
                                .collect(Collectors.toList())
                        );
        Comparator<Course> comparingByNoStudentsAndReviewScore =Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore);

        //sorted by review score
        System.out.println("comparingByNoStudentsAndReviewScore");
        System.out.println(
        courses.stream()
                .sorted(comparingByNoStudentsAndReviewScore)
                .collect(Collectors.toList())
        );
        //[FullStack:14000:91, Spring Boot:18000:95, Kubernetes:20000:91, Docker:20000:92, Spring:20000:98, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        //Filter
        System.out.println("Filter");
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoStudentsAndReviewScore)
                        .limit(5) //only first 5 registers
                        .skip(3)
                        .collect(Collectors.toList())
        );
       // [FullStack:14000:91, Spring Boot:18000:95, Kubernetes:20000:91, Docker:20000:92, Spring:20000:98]
        //skip
        System.out.println("Skip");
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoStudentsAndReviewScore)
                        .limit(5)
                        .skip(3) //exclude first three registers
                        .collect(Collectors.toList())
        );
        // [FullStack:14000:91, Spring Boot:18000:95, Kubernetes:20000:91, Docker:20000:92, Spring:20000:98]

        //takeWhile
        System.out.println("TakeWhile");
        System.out.println(
        courses.stream()
                .takeWhile(course->course.getReviewScore()>=95)
                .collect(Collectors.toList())
        );
        //dropWhile
        System.out.println("dropWhile");
        System.out.println(
                courses.stream()
                        .dropWhile(course->course.getReviewScore()>=95)
                        .collect(Collectors.toList())
        );
    }
}













