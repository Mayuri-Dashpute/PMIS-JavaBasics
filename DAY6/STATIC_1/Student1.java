
package DAY6.STATIC_1;

public class Student1 {
    String name;
    static String CollegeName = "IIT Bombay";

    Student1(String name) {
        this.name = name;
    }

    void stucol() {
        System.out.println(name + " studies in " + CollegeName);
    }
}
