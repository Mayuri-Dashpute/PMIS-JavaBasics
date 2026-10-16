package DAY10.Lambda;

import java.util.function.Consumer;

public class Consumere {
    public static void main(String[] args) {

        Consumer<String> pr = message -> System.out.println(message);

        pr.accept("Hello Java");
    }
}