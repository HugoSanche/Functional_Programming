import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//WORK WITH SUM, AVERAGE, COUNT
public class PF04CustomClass_C {
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
        Predicate<Course> reviewScoreGreaterThan95Predicate= course->course.getReviewScore()>95;

        Predicate<Course> reviewCategoryEqualToCloud=course -> course.getCategory().equalsIgnoreCase("cloud");

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate) //return score >95
                        .collect(Collectors.toList())

        );


        System.out.println("SUM");
        System.out.println(
        courses.stream()
                .filter(reviewScoreGreaterThan95Predicate) //return score >95
                //.collect(Collectors.toList())
                .mapToInt(Course::getNoOfStudents)//return the value of noOfStudents
                .sum()//sum the noOfStudents
        );

        System.out.println("AVERAGE");
        System.out.println(
        courses.stream()
                .filter(reviewScoreGreaterThan95Predicate) //return score >95
                //.collect(Collectors.toList())
                .mapToInt(Course::getNoOfStudents)//return the value of noOfStudents
                .average() //sum the noOfStudents
        );

        System.out.println("COUNT");
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate) //return score >95
                        //.collect(Collectors.toList())
                        .mapToInt(Course::getNoOfStudents)//return the value of noOfStudents
                        .count() // COUNT the noOfStudents
        );

        System.out.println("MAX");
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate) //return score >95
                        //.collect(Collectors.toList())
                        .mapToInt(Course::getNoOfStudents)//return the value of noOfStudents
                        .max() //MAX NO OF the noOfStudents
        );
        System.out.println("Exercises");
        /*EXERCISES*/
        System.out.println(
        courses.stream()
                .filter(reviewCategoryEqualToCloud)
                .mapToInt(Course::getReviewScore)
                .average()
        );
    }
}
