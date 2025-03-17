
// String Maupulation: question: Write a program to reverse a given string.
import java.util.Scanner;

public class ReverseString {

    public static String reversedString(String str) {

        char charArr[] = str.toCharArray();

        int start = 0;
        int end = charArr.length - 1;
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string to be reversed:");
        String string = sc.nextLine();

        System.out.println("The given String " + string + " is reversed as :" + reversedString(string));

        sc.close();
    }
}