package DAY7.Wrapper_class;

public class Problem1 {
    public static void main(String[] args) {
       String input =  "10,25,40,15,60";
       String arr[] = input.split(",");
       int total =0;

       for(String part : arr){
        total += Integer.parseInt(part);

       }
       System.out.println("Total sum: "+total);
    }
    
}
