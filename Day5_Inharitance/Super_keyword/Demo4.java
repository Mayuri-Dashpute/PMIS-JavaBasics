package Day5_Inharitance.Super_keyword;

public class Demo4 {
    public static void main(String[] args) {
        Dog dg = new Dog();
        dg.name = "Tommy";
        System.out.println("dog name is:"+dg.name);

        dg.eat();
        dg.bark();
    }
    
}
