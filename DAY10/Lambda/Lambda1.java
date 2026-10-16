/*
Built in functional interface
Predicate<T> test(t) T -> t/f 1/0
 */

package DAY10.Lambda;
import java.util.*;
import java.util.function.Predicate;
public class Lambda1 {
    public static void main(String[] args) {
        Predicate<Integer> isAdult = age -> age>=18;
        System.out.println(isAdult.test(20));
         System.out.println(isAdult.test(15));
    }
    
}
