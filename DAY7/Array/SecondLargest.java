package DAY7.Array;
import java.util.Scanner; 
public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        if(n<2){
            System.out.println("Array must contain at least 2 ele");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
             } 
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;   
        
        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] >  secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        
            
        }
        if(secondLargest == Integer.MIN_VALUE){
            System.err.println("No second largest distict element found");
        }else{
            System.err.println("second largest element: "+ secondLargest);
        }
        
    }
    
}
