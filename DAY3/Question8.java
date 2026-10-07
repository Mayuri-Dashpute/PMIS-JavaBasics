package DAY3;
import java.util.Scanner;
public class Question8 {
    static void powerSum(int x, int n){
        int power = (int) Math.pow(x,n);
System.out.println("power is:" + power);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x:");
        int x = sc.nextInt();
        System.out.print("Enter n:");
        int n = sc.nextInt();
        powerSum(x,n);

    }
    
}
