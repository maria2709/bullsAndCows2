import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
    //    System.out.println("Input a, b and c:");
        do {
            a = sc.nextDouble();
            if (a == 0) {
                System.out.println("Input a not equal 0:");
            } else break;
        } while (a == 0);
        b = sc.nextDouble();
        c = sc.nextDouble();
        System.out.println(countX(a, b, c));
    }

    private static double countX(double a, double b, double c){
        return (c - b)/a;
    }
}
