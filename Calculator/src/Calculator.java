import java.util.Scanner;

public class Calculator {
    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public static int pow(int base, int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base;
        }

        return result;
    }

    public static int sqrt(int number) {
        int root = 1;
        for (int i = 1; i < number + 1; i++) {
            root = (number / root + root) / 2;
        }
        return root;
    }

    public static int modeRetrieval(int number, int mod) {
        return number % mod;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int extraction(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalStateException("Baska Sayı Gırınız");
        }
        return a / b;
    }

    public static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void derivative(int derece, int[] katsayı) {
        Scanner klavye = new Scanner(System.in);
        katsayı = new int[derece + 1];
        System.out.println("Denklemin Katsayılarını Giriniz");
        for (int i = 0; i < katsayı.length; i++) {

            katsayı[i] = klavye.nextInt();
        }

        System.out.println("Denklemin Türevi: ");
        for (int i = 0; i < katsayı.length - 1; i++) {
            System.out.print(katsayı[i] * (derece - i) + " ");
        }
    }

}


