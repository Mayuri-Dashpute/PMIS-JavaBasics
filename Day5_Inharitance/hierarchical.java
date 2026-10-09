package Day5_Inharitance;
class Shape{
    String color = "Red";

}
class Circle extends  Shape{
    void drawCircle(){
        System.out.println("drawing a" + color+"circle");

    }

}
class Rectangle extends Shape{
    void drawRectangle(){
         System.out.println("drawing a" + color+"rect");
    }

}
public class hierarchical {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        c.drawCircle();
        r.drawRectangle();
    }
}
