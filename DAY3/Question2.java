/*package DAY3;
import java.util.Scanner;
public class Question2 {
    static int oddSum(int n){
        int sum = 0;
        for (int i = 1; i<=n; i++){
            if(i % 2 != 0){
                sum = sum + i;

            }
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
         int result = oddSum(n);
         System.out.println("sum is: " +result);
    }
}*/


package DAY3;
import java.util.Scanner;
public class Question2 {
    static void oddSum(int n){
        int sum = 0;
        for (int i = 1; i<=n; i++){
            if(i % 2 != 0){
                sum = sum + i;

            }
        }
        System.out.println("sum is:"+sum);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
          oddSum(n);
         
    }
}
