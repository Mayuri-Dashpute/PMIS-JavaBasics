package DAY6.Abstract;

public class App {
    public static void main(String[] args) {
        Shape rc = new Rectangle(7, 8);
        Shape cr = new Circle(9);
        rc.setcolor("red");
         cr.setcolor("blue");

         System.out.printf("%s circle area is %.2f\n" , cr.getcolor() , cr.calculateArea());
         System.out.printf("%s circle area is %.2f\n" , rc.getcolor(), rc.calculateArea());
    }
    
}


