package hust.soict.globalict.garbage;
import java.util.Random;
public class NoGarbage {
	public static void main(String[] args) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();

        // Generate a large amount of data without creating excessive garbage
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(random.nextInt(2));
        }

        System.out.println("Optimized garbage creation, length: " + stringBuffer.length());
    }
}
