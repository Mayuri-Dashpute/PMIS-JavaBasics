package DAY10.StreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class Stream5 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 12, 8, 3, 20, 7);

        List<Integer> result = nums.stream()
        .sorted()
         .collect(Collectors.toList());
         System.out.println(result);

    }
}
