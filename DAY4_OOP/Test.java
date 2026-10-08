package DAY4_OOP;
class Car{
    private String color;
    private  String brand;
    private int speed;

    public Car(){

    }

    public Car(String color, String brand, int speed){
        this.color = color;
        this.brand = brand;
        this.speed = speed;
    }
    void displayInfo(){
        System.out.println(color+"\n"+brand+"\n"+speed);
    }

    void accelerate(int incr){
        int or_speed = speed;
        speed += incr;
        System.out.println("original speed:" + or_speed);
        System.out.println(brand+"accelerated by"+ speed+ "Km/hr");
    }

}
public class Test {
    public static void main(String args[]){
       Car c1 = new Car("red","BMW", 300);
       c1.displayInfo( ) ;
       c1.accelerate(50);
    }
}
