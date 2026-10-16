
package DAY10.StreamAPI;

import java.util.*;
import java.util.stream.*;

public class Stream1 {
    /*public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = new ArrayList<>();

        for (int n : nums) {
            if (n % 2 == 0) {
                result.add(n * n);
            }
        }

        System.out.println(result);
    }*/


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> res = nums.stream()
        .filter(n -> n%2 == 0)
        .map(n -> n*n)
        .collect(Collectors.toList());
        System.out.println("List: " + nums);
        System.out.println("Result: "+ res);
        
    }
}
