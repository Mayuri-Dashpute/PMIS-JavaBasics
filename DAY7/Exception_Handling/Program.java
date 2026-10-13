package DAY7.Exception_Handling;
import java.util.*;
public class Program {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1");
        int num1 =sc.nextInt();
        System.out.println("Enter num1");
        int num2 =sc.nextInt();

        try{
            int res = num1 / num2;
            System.out.println(res);
        }catch(ArithmeticException e){
            System.out.println("you cant divide by 0");
        }

    }
}
