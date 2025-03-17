import java.util.Scanner;
// DATA TYPES AND OPERATORS: Qestions2) Write a program to demonstrate the use of arithmetic, logical, and relational operators.

public class Operators {
    // Arithmetic Operators
    public static void arithmetic(int num1, int num2) {
        System.out.println("ARITHMETIC OPERATIONS:");
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));
        System.out.println("Modulus: " + (num1 % num2));
        System.err.println();
    }

    // Logical operators

    public static void logical(int num1, int num2, int num3) {
        System.out.println("LOGICAL OPERATIONS:");
        System.out.println("num1 > num2 && num1 < num3: " + (num1 > num2 && num1 < num3)); // true
        System.out.println("num1 > num2 || num1 > num3: " + (num1 > num2 || num1 > num3)); // true
        System.out.println("!(num1 > num2): " + !(num1 > num2));
        System.out.println();
    }

    // Relational Operators
    public static void relational(int num1, int num2) {
        System.out.println("RELATIONAL OPERATIONS:");
        System.out.println("num1 == num2: " + (num1 == num2));
        System.out.println("num1 != num2: " + (num1 != num2));
        System.out.println("num1 > num2: " + (num1 > num2));
        System.out.println("num1 < num2: " + (num1 < num2));
        System.out.println("num1 >= num2: " + (num1 >= num2));
        System.out.println("num1 <= num2: " + (num1 <= num2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter thre integers");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        arithmetic(num1, num2);
        logical(num1, num2, num3);
        relational(num1, num2);

        sc.close();
    }
}
