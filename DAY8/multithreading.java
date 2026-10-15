package DAY8;

public class multithreading extends Thread{
    public void run()
    {
        System.out.println("Thred is running...");
    }
    public static void main(String[] args) {
        multithreading m = new multithreading ();
        m.start();
    }
    
}





