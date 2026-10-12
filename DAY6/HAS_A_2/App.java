package DAY6.HAS_A_2;

public class App {
    public static void main(String[] args) {
        Address ad = new Address("Mumbai", "M1", 677677);
        Student s1 = new Student("varun", 101, ad);
        s1.displayProfile();
    }
    
}
