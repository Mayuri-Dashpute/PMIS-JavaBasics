package Day5_Inharitance;
class Device{
    void poweron(){
        System.out.println("device power on");
    }

}
class Phone extends Device{
    void makecall(){
        System.out.println("calling the number");
    }

}
class SmartPhone extends Phone{
    void browerInternet(){
        System.out.println("opening browser");
    }

}
public class MultiLevel {
    public static void main(String[] args) {
        SmartPhone sm = new SmartPhone();
        sm.poweron();
        sm.makecall();
        sm.browerInternet();
    }
}
