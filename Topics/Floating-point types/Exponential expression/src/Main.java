import java.util.Scanner;

import static java.lang.Math.pow;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double result = pow(x,3) + pow(x,2) + x +1;
        System.out.println(result);
    }
}