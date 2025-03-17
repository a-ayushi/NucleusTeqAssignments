import java.util.Arrays;
import java.util.Scanner;
// String Manupulation: Question:Create a program to check if two strings are anagrams.

public class CheckIfAnagram {

    public static boolean ifAnagram(String str1, String str2) {
        // convert to lower case and remove space if any
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        System.out.println(str1);
        System.out.println(str2);
        // case 1: if lengths aree different
        if (str1.length() != str2.length())
            return false;

        // case 2: lengths are equal
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        if (Arrays.equals(charArr1, charArr2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two string to check if they are anagrams of each other or not:");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        if (ifAnagram(str1, str2)) {
            System.out.println("the Strings are Anagrams!");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
        sc.close();
    }
}
