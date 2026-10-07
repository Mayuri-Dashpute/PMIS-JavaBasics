package DAY3;
import java.util.Scanner;
public class Question4 {
    static int circumference(int r){
        int c = (int) (2*3.14*r);
        return c;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius:");
        int r = sc.nextInt();
        int result = circumference(r);
        System.out.println("circumference is" +" " +result);

    }
}
