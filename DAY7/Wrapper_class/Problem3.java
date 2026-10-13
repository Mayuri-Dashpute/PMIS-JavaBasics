package DAY7.Wrapper_class;
import java.util.*;
public class Problem3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(22);
        numbers.add(21);
        numbers.add(7);
        numbers.add(11);
        numbers.add(91);
        numbers.add(50);
        numbers.add(55);

        List<Integer> evens = new ArrayList<>();
        for(Integer num : numbers){
            if(num % 2 == 0){
                evens.add(num);
            }
        }
        System.out.println("Even numbers: "+evens);

    }
}
