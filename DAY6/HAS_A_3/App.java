package DAY6.HAS_A_3;

public class App {
    public static void main(String[] args) {
        Battery b =  new Battery(250);
        Camera c = new Camera(340);
        Phone p = new Phone("mptprola" ,b, c);
        p.snapPicture();
    }
}
