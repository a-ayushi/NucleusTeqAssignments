import java.util.Scanner;

public class LinearSearch {
    public static int search(int[] arr, int size, int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Taking array size input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        // Declaring array
        int[] arr = new int[size];

        // Taking array elements as input
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // Taking key as input
        System.out.println("Enter the number to be searched");
        int key = sc.nextInt();

        int result = search(arr, size, key);
        if (result == -1)
            System.out.println("Element not found!!");
        else
            System.out.println("Element is present at position: " + (result + 1));

        sc.close();
    }

}
