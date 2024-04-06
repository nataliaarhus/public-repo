import java.util.Random;
import java.util.ArrayList;

public class testRandomInts {
    public static void main(String[] args) {
        final Random rnd = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int test = 1; test <= 3; test++) {
//            System.out.println("Test number " + test);
            int length = 10 + rnd.nextInt(15);
            for (int i = 0; i < length; i++) {
                numbers.add(15 - rnd.nextInt(30));
            }
        }
        System.out.println("List: " + numbers);

        int positives = 0;
        int negatives = 0;
        for (int num : numbers) {
            if (num > 0) {
                positives = positives + 1;
            } else if (num < 0) {
                negatives = negatives + 1;
            }
        }
        System.out.println("Positives: " + positives);
        System.out.println("Negatives: " + negatives);
    }
}