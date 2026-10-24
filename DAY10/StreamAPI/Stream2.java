package DAY10.StreamAPI;
import java.util.*;
import java.util.stream.*;
public class Stream2 {
    public static void main(String[] args) {
        List<String> list = List.of("a","b","c");
        System.out.println("stream from alist: ");
        list.stream().forEach(System.out::println);
        int arr[] = {1,2,3};
        Arrays.stream(arr).forEach(System.out::println);
        Stream.of("x","y","z").forEach(System.out::println);
        IntStream.range(1,5).forEach(System.out::println);

    }
}
