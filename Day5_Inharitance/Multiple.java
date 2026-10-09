package Day5_Inharitance;
interface Mother{
    void msg();
}
interface Father{
    void call();
}

class Child implements Mother, Father{
    @Override 
    public void msg(){
        System.out.println("msg from both");
    }
    @Override 
    public void call(){
        System.out.println("call from both");
    }

}
public class Multiple {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.msg();

        Mother m = new Child();
        m.msg();

        Father f = new Child();
        f.call();
    }
}
