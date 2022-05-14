import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream limitedIntStreamWithinARange = random.ints(0, 9);
        System.out.println(limitedIntStreamWithinARange.toString().substring(0,1));
    }
}
