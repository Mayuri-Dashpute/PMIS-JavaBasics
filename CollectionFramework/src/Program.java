
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("USA");
        list.add("France");
        list.add("Italy");
        list.add("Iran");
        list.add("Isreal");
        list.add("England");
        System.out.println("size : "+list.size()); // 7
        System.out.println("toString() : "+ list.toString());

        //random access -- get() , set() , add() , remove()
        list.add(3, "Germany");
        System.out.println("toString() : "+ list.toString());

        int index = 5;
        String e5 = list.get(index);
        System.out.println("Ele : "+e5); //Ele : Iran

        //set()
        e5 = e5.toUpperCase();
        list.set(index, e5);
        System.out.println("toString() : "+ list.toString());//[India, USA, France, Germany, Italy, IRAN, Isreal, England]

        //remove()
        list.remove(index);
        System.out.println("toString() : "+ list.toString());//[India, USA, France, Germany, Italy, Isreal, England]

        //contains()
        String find = "USA";
        boolean found = list.contains(find);
        if(found)
            System.out.println(find + " found ");
        else
            System.out.println("Not found");

        //indexOf() , lastIndexOf()
        int idx = list.indexOf(find);
        if(idx!=-1) {
            System.out.println(find + " found at index" +idx);
        }
        else
            System.out.println(find + " not found");
        idx = list.lastIndexOf(find);
        if(idx!=-1) {
            System.out.println(find + " found at index" +idx);
        }
        else
            System.out.println(find + " not found");
        System.out.println();
        System.out.print("FWD : ");

        ListIterator<String> trav = list.listIterator();
        while(trav.hasNext()) {
            String ele = trav.next();
            System.out.print(ele + " ");
        }
        System.out.println();
        System.out.print("REV : ");
        trav = list.listIterator(list.size());
        while(trav.hasPrevious()) {
            String ele = trav.previous();
            System.out.print(ele + " ");
        }
        System.out.println();
        list.clear();
        Collections.addAll(list,"Rohan","Amit","Sagar","Rahul","Akshay");
        Collections.sort(list); //Natural ordering
        System.out.println("toString() : "+ list.toString());

        Collections.shuffle(list);

        class StringComparator implements Comparator<String>{

            @Override
            public int compare(String x, String y) {
                int diff = y.compareTo(x);
                return diff;
            }

        }
        Collections.sort(list, new StringComparator());
        System.out.println("toString() : "+ list.toString());

    }
}







