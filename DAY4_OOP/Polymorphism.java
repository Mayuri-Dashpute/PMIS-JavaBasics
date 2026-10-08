package DAY4_OOP;
class Claculator{
    int add(int a, int b){
    return a+b;
    }

    int add(int a, int b, int c){ 
    return a + b + c;
    }  
    
    double add(double a, double b){
        return a + b;    
    } 
}


class Animal{
void makeSound(){
    System.out.println("Animal makes a sound");
}
}

class Dog extends Animal{
    @Override
    void makeSound(){
    System.out.println("Dog barks");
}
}

class cat extends Animal{
    @Override 
    void makeSound(){
    System.out.println("cat meow");
}
}
public class Polymorphism {
    public static void main(String args[]){
        Animal aa1 = new Dog();
        Animal aa2 = new cat();
        Animal aa3 = new Animal();

        aa1.makeSound();
        aa2.makeSound();
        aa3.makeSound();
    }
    
}
