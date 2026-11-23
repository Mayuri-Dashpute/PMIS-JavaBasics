import java.util.Scanner;
public class Main {
    public static void moveHash(String a, int len){
        String str1 = "";
        String str2 = "";
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)=='#') {
                str1 = str1 + a.charAt(i);
            }else{
                str2 = str2 + a.charAt(i);
            }
        }
        String result = str1 + str2;
        System.out.println(result);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int len = a.length();
        moveHash(a, len);
    }
}