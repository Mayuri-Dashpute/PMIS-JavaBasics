package DAY3;
import java.util.*;
public class Question1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=1; i<=3; i++){
            System.out.println("Enter num" +i);
            int num = sc.nextInt();
            sum =  sum + num;
        }
        double avg = sum / 3.0;
        System.out.println("avg is:" +avg);


    }
}
