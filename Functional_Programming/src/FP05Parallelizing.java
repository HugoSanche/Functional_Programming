import java.util.stream.LongStream;

public class FP05Parallelizing {

    /*WHEN YOU USED PARALLEL()
    * Parallel streams are a powerful tool that can be used to improve the performance of your Java code.
    * However, it is important to use them wisely, as they can also introduce some overhead.
    *
        Here are some of the situations where you should consider using parallel streams:

            When you have a large amount of data to process.
            When the individual operations are relatively quick.
            When the order of the results does not matter.
            When the operations are independent of each other.
    * */

    public static void main(String[] args) {

        long time=System.currentTimeMillis();

        //Check the difference between using parallel(), AMAZING!!!

        //Time execution 1798
       // LongStream.range(0,1000000000).sum();//1798

        //Time execution 85
        LongStream.range(0,1000000000).parallel().sum();//85

        System.out.println(System.currentTimeMillis()-time);
    }
}
