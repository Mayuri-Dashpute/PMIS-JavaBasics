package DAY7.Array;
import java.util.*;
public class Avg_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter ele");
        for(int i =0; i<n; i++){
           arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
           
        }

        double avg = (double)sum / n;
         System.out.println("sum: "+sum);
        System.out.println("avg: "+avg);
    }
}
