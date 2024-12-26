package hust.soict.globalict.garbage;
import java.util.Random;
public class GarbageCreator {
	public static void main(String[] args) {
        Random random = new Random();
        String garbage = "";

        // Generate a large amount of "garbage"
        for (int i = 0; i < 100000; i++) {
            garbage += random.nextInt(2);  // Creates a lot of temporary String objects
        }

        System.out.println("Garbage created, length: " + garbage.length());
    }
}
