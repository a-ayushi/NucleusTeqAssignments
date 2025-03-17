import java.util.Scanner;
// Arrays:Question :1) Write a program to find the average of elements in an array.

public class AvgOfArrayEle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Taking array size input
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        // Declaring array
        int[] numbers = new int[size];
        int sum = 0;

        // Taking array elements as input
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i]; // Adding elements to sum
        }

        // Calculating average
        double average = (double) sum / size;

        System.out.println("The average of the array elements is: " + average);

        sc.close();
    }
}