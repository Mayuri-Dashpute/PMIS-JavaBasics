
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter count of numbers");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Check occurrence
        for(int i = 0; i < arr.length; i++) {

            int count = 0;
            boolean visited = false;

            // Check whether element was already counted
            for(int k = 0; k < i; k++) {
                if(arr[i] == arr[k]) {
                    visited = true;
                    break;
                }
            }

            if(visited) {
                continue;
            }

            // Count occurrences
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }

            System.out.println(arr[i] + " occurs " + count + " times");
        }

        sc.close();
    }
}
