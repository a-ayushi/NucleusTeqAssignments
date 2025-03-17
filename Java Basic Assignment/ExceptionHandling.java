
// Create a program to handle exceptions using try-catch blocks.

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("ENter a number:");
            int number = sc.nextInt();// may lead to InputMistachException

            int[] arr = { 1, 2, 3, 4, 5 };// can lead to arrayIndexOutOfBoundExveption
            System.out.println("array Element:" + arr[number]);
        } catch (InputMismatchException e) {
            System.out.println("Error: ENter a valid Integer value.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bound");
        } finally {
            sc.close();
        }
    }
}
