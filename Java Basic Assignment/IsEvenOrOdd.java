import java.util.Scanner;

public class IsEvenOrOdd {
    public static boolean isEven(int number) {
        if (number % 2 == 0)
            return true;
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check weather it is Even or odd");
        int number = sc.nextInt();

        System.out.println("The number " + number + (isEven(number) ? " is EVEN!" : " is ODD!"));

        sc.close();
    }
}
