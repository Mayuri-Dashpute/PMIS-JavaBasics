
import java.util.Scanner;

public class Main2 {

    public static void countChar(String a) {

        String uni = "";

        // Step 1: Find unique characters
        for (int i = 0; i < a.length(); i++) {

            int count = 0;

            for (int j = 0; j <= i; j++) {

                if (a.charAt(i) == a.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                uni = uni + a.charAt(i);
            }
        }

        // Step 2: Count frequency
        for (int k = 0; k < uni.length(); k++) {

            int count = 0;

            for (int j = 0; j < a.length(); j++) {

                if (uni.charAt(k) == a.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.print(uni.charAt(k));
            } else {
                System.out.print(uni.charAt(k) + "" + count);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        countChar(a);
    }
}
