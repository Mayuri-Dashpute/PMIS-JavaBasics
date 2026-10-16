/*
No parameters: () -> syso("Hi")
one : x-> x*2
two parameter: (a,b) -> a+b;
(int a, int b) -> a+b;

*/


package DAY10.Lambda;
@FunctionalInterface 
interface Greeter{
void greet(String name);
} 

public class Lambda {
  /*public static void main(String[] args) {
    Greeter g = new Greeter() {
        @Override 
        public void greet(String name){
            System.out.println("Hello "+ name);
        }
    };
    g.greet("Mayuri");
    
  } */ 

    public static void main(String[] args) {
        Greeter g = name -> System.out.println("Hello, " + name);
    }
}


