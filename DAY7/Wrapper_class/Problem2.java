package DAY7.Wrapper_class;


public class Problem2 {
    public static void main(String[] args) {
        String password = "Pass@1234_Mumbai";
        int upper = 0;
        int lower = 0;
        int digits = 0;
        int special = 0;

        for(char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper++;
            }else if (Character.isLowerCase(ch)){
                lower++;
            }else if(Character.isDigit(ch)){
                digits++;

            }else{
                special++;
            }
        }
        System.out.println("Uppercase: " +upper);
        System.out.println("Uppercase: " +lower);
        System.out.println("Uppercase: " +digits);
        System.out.println("Uppercase: " +special);

     }
}
