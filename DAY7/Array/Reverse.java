package DAY7.Array;
import java.util.*;
public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter element: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = n-1;

        while (start < end) { 
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
         } 
         System.out.println("Reversed Array: ");
         for(int i=0; i<n; i++){
            System.out.println(arr[i]+ " ");
         }
         System.out.println();
    }
    
    
}
