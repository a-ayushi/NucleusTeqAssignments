import java.util.Scanner;

public class CountVewels {

    public static int countVewels(String str) {
        // convert in any case so that comparison becomes a bit easy
        str = str.toLowerCase();
        int totalVowels = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                totalVowels++;
            }
        }
        return totalVowels;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String to know the number of vowels in it:");
        String str = sc.nextLine();

        System.out.println("Total number of vowels in " + str + " is: " + countVewels(str));

        sc.close();
    }
}
