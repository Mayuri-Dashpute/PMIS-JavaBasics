package DAY10.Lambda;


import java.util.function.Function;

public class Square {
    public static void main(String[] args) {

        Function<Integer, Integer> square = n -> n * n;

        System.out.println(square.apply(5));
    }
}