package DAY10.Lambda;

import java.util.function.*;

public class Lambda3 {
    public static void main(String[] args) {

        Supplier<String> message = () -> "Welcome";

        System.out.println(message.get());
    }
}