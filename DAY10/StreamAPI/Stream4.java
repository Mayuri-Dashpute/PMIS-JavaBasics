package DAY10.StreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class Stream4 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 12, 8, 3, 20, 7);

        List<Integer> result = nums.stream()
        .map(n -> n * 2)
         .collect(Collectors.toList());
         System.out.println(result);

    }
}
