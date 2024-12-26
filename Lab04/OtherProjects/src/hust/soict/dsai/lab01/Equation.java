package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Equation{
    public static String BacNhat(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                return "Phương trình có vô số nghiệm.";
            } else {
                return "Phương trình vô nghiệm.";
            }
        } else {
            double x = -b / a;
            return "Nghiệm của phương trình là x = " + x;
        }
    }
    public static String HePhuongTrinh(double a11, double a12, double b1, double a21, double a22, double b2) {
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                return "Hệ phương trình có vô số nghiệm.";
            } else {
                return "Hệ phương trình vô nghiệm.";
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            return "Nghiệm của hệ phương trình là x1 = " + x1 + " và x2 = " + x2;
        }
    }
    public static String BacHai(double a, double b, double c) {
        if (a == 0) {
            return BacNhat(b, c);
        }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có hai nghiệm phân biệt: x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép: x = " + x;
        } else {
            return "Phương trình vô nghiệm";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn loại phương trình cần giải:");
        System.out.println("1. Phương trình bậc nhất (ax + b = 0)");
        System.out.println("2. Hệ phương trình bậc nhất");
        System.out.println("3. Phương trình bậc hai (ax^2 + bx + c = 0)");

        int luaChon = sc.nextInt();

        switch (luaChon) {
            case 1:
                System.out.println("Nhập các hệ số a và b:");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                System.out.println(BacNhat(a, b));
                break;
            case 2:
                System.out.println("Nhập các hệ số a11, a12, và b1 cho phương trình thứ nhất:");
                double a11 = sc.nextDouble();
                double a12 = sc.nextDouble();
                double b1 = sc.nextDouble();

                System.out.println("Nhập các hệ số a21, a22, và b2 cho phương trình thứ hai:");
                double a21 = sc.nextDouble();
                double a22 = sc.nextDouble();
                double b2 = sc.nextDouble();

                System.out.println(HePhuongTrinh(a11, a12, b1, a21, a22, b2));
                break;
            case 3:
                System.out.println("Nhập các hệ số a, b, và c: ");
                double aBacHai = sc.nextDouble();
                double bBacHai = sc.nextDouble();
                double cBacHai = sc.nextDouble();
                System.out.println(BacHai(aBacHai, bBacHai, cBacHai));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1, 2 hoặc 3.");
                break;
        }

        sc.close();
    }
}
