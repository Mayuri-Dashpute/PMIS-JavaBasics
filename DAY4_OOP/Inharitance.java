package DAY4_OOP;
class Vehicle{
    String brand;

    void startEngine(){
        System.out.println(brand + " engine started");
    }
}
 class Bike extends  Vehicle{
    boolean hascarrier;
    void kickStand(){
        System.out.println("kickstand put down");
    }
 }
public class Inharitance {
   public static void main(String args[]){
    Bike myBike = new Bike();
    myBike.brand = "shine";
    myBike.startEngine();
    myBike.kickStand();

   } 
}
