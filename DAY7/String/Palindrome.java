package DAY7.String;
import java.util.Scanner; 
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        int left = 0;
        int right = str.length()-1;
        boolean isPalindrome = true;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
             System.out.println("The string is a palindrome");
             } else { 
            System.out.println("The string is not a palindrome");
         } 
    }
}
