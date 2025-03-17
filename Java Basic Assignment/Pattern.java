import java.util.Scanner;
// BASIC JAVA : Question 5) Use loops to print patterns like a triangle or square.

// NOTE: we can use switch case also, like we can ask user which shape they want to print and then call that method
// Here i am calling both the methods
public class Pattern {

    // method to print a square pattern
    public static void printSquare(int square) {
        for (int i = 1; i < square; i++) {
            for (int j = 1; j < square; j++) {
                System.out.println("*");
            }
        }

    }

    // method to print a trangle pattern
    public static void printTriangle(int triangle) {
        for (int i = 1; i <= triangle; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("* ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of square");
        int square = sc.nextInt();

        System.out.println("Enter the size of triangle:");
        int triangle = sc.nextInt();

        printSquare(square);
        printTriangle(triangle);

        sc.close();
    }
}
