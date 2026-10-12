package DAY1;
import java.util.*;
public class todoq {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter num1: ");
    int a = sc.nextInt();
    System.out.println("Enter num2: ");
     int b = sc.nextInt();
     a = a+b;
     b = a-b;
     a = a-b;
     System.out.println(a);
     System.out.println(b);
    
    }
}
