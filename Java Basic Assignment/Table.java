// Control flow Statements : QUEstion: 3) Use a for loop to print a multiplication table

import java.util.Scanner;

public class Table {
    // method to print the multiplication table of given number
    public static void printTable(int num) {

        System.out.println("Multiplication table of " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to print its multiplication table:");
        int num = sc.nextInt();

        // call the method
        printTable(num);

        sc.close();
    }
}
