package hust.soict.dsai.lab01;
import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("so thu nhat: ");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        System.out.print("so thu hai: ");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = 0;
        if (num2 != 0) {
            quotient = num1 / num2;
        } 
        else {
            System.out.println("Loi: Khong the chia cho so 0");
        }

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if (num2 != 0) {
            System.out.println("Quotient: " + quotient);
        }
        scanner.close();
}
}
