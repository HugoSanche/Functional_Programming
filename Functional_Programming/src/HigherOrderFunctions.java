import java.util.function.Predicate;

public class HigherOrderFunctions {

    //Returning a method from a method
    public static void main(String[] args) {


        Predicate<Course> reviewScoreGraterThan95Predicate = createPredicateWithReviewScore( 95);

        Predicate<Course> reviewScoreGraterThan90Predicate = createPredicateWithReviewScore( 90);

    }
    private static Predicate<Course> createPredicateWithReviewScore(int reviewScores){
        return course -> course.getReviewScore()>reviewScores;
    }

}
