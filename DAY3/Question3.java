package DAY3;
import java.util.Scanner;
public class Question3 {
    static void greater(int n1, int n2){
        if(n1>n2){
            System.out.println(+n1+ " "+"is greater");
        }else{
            System.out.println(n2+ " " +"is greater");
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n1:");
        int n1 = sc.nextInt();
        System.out.print("Enter n2:");
        int n2 = sc.nextInt();
        greater(n1,n2);


    }
    
}
