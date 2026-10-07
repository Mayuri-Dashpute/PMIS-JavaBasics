package DAY3;
import java.util.Scanner;
public class Question5 {
    static void ageCalculate(int age){
        if(age > 18){
            System.out.println("eligible to vote");
        }else{
            System.out.println("not eligible");
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age:");
        int age = sc.nextInt();
        ageCalculate(age);
    }
    
}
