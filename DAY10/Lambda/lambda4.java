package DAY10.Lambda;
/*
consumer<T> : T -> "Hello, "Hi" .acceot() 
*/
import java.util.function.Consumer;

public class lambda4 {
  public static void main(String[] args) {
    Consumer<String> smsnotifier = mobNo -> {
        System.out.println("Sending the otp to the :" +mobNo);
    };
    smsnotifier.accept("+91 2343858");
  }  
}


