package DAY3;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        int positive =0;
        int negative = 0;
        int zero =0;


        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to enter: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = sc.nextInt();
            System.out.println("You entered: " + num);
        

        if(num > 0){
            positive++;
            System.out.println(positive);
        }else if(num < 0){
            System.out.println(negative);
            negative++;
        }else{
            System.out.println(zero);
            zero++;
        }
    }

         System.out.println("Positive:"+positive);
          System.out.println("negative:"+negative);
          System.out.println("Zero:"+zero);

    }
}