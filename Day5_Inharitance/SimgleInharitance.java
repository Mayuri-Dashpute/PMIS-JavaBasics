package Day5_Inharitance;
class Animal{
void eat(){
    System.out.println("This Animal eats food");
}
}

class Dog extends Animal{
    void bark(){
        System.out.println("dog barks");
    }
}
public class SimgleInharitance {
   public static void main(String[] args) {
     Dog d = new Dog();
     d.eat();
     d.bark();
   } 
}
