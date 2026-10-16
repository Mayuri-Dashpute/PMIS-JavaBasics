package DAY10.Lambda;
import java.util.function.*;
import java.util.*;
public class OPT {
public static void main(String[] args) {
    Supplier<String> otpGen = () -> {
    Random random = new Random();
    int number = 10000 + random.nextInt(9000000);
    return String.valueOf(number);
};
String userOtp = otpGen.get();
System.out.println("The otp is: "+ userOtp);
}
}