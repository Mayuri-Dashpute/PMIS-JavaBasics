import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = new LinkedList<>();
        c.add("India");
        c.add("USA");
        c.add("China");
        c.add("USA");
        c.add("Italy");
        c.add("France");
        c.add("Nepal");
        System.out.println("toString() : " + c.toString());
        System.out.println("Size : "+c.size());
        c.remove("USA");
        System.out.println("toString() : " + c.toString());
        c.remove("Nepal");
        for(String s : c) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("FWD : ");
        Iterator<String> trav = c.iterator();
        while(trav.hasNext()) {
            String ele = trav.next();
            System.out.println(ele);
        }


        c.clear();
        System.out.println("Size : "+c.size());




    }
}