import java.util.Scanner;

public class Fibonacci {

    // method to print the Fibonacci Seqence
    public static void fibonacci(int limit) {
        int f0 = 0;
        int f1 = 1;
        System.out.println("Fibonacci Sequence upto limit" + limit);

        while (f0 <= limit) {
            System.out.print(" " + f0);
            int fnext = f0 + f1;
            f0 = f1;
            f1 = fnext;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the limit of fibonacci Sequence:");
        int limit = sc.nextInt();
        fibonacci(limit);

        sc.close();
    }
}
