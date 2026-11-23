import java.util.Scanner;
public class Main3 {
    public static Long calculate(long a, long b, long c){
        long result = (a + b) * (a + b) * (a + b);
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long ans = calculate(a,b,c);
        System.out.println(ans);

    }
}
