package DAY6.Abstract;

abstract class Shape {
    private  String color;
    void setcolor(String color){
        this.color = color;
    }
    String getcolor(){
        return color;
    }
    abstract double calculateArea();
}

class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    @Override 
    double calculateArea(){
        return(3.14) * radius * radius;
    }

}

class Rectangle extends Shape{
    double length, bredth;
    Rectangle(double length, double bredth){
        this.length = length;
        this.bredth=bredth;
    }
    @Override 
    double calculateArea(){
        return length * bredth;
    }
}
