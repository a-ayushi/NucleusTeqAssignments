// Control flow statements: QUESTION :2) Implement a program to find the largest number among three given numbers using a conditional statement.

import java.util.Scanner;

public class LargestOfThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter Three Integers:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int largest;
        // Using if-else conditions to find the largest number
        if (num1 >= num2 && num1 >= num3) {
            largest = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            largest = num2;
        } else {
            largest = num3;
        }

        System.out.println("Largest number is:" + largest);

        sc.close();

    }
}
