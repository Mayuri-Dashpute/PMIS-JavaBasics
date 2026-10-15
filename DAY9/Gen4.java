package DAY9;
import java.util.*;
public class Gen4 {
    public static void printList(List<?> list) {
        for(Object o: list){
            System.out.println(o);
        }
        
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anish", "varun", "tarun");
        List<Integer> name = Arrays.asList(100,99,98);
        List<Double> prices = Arrays.asList(67.9,78.7);
        System.out.println("names: ");
        printList(names);
        System.out.println("\nname: ");
        printList(name);
        System.out.println("\nPrices: ");
        printList(prices);
    }
}
