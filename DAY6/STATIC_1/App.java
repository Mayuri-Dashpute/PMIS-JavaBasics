
package DAY6.STATIC_1;

public class App {
    public static void main(String[] args) {

        Student1 student = new Student1("Mayuri");
        Student1 stu = new Student1("Mahi");

        System.out.println(Student1.CollegeName);

        student.stucol();
        stu.stucol();
    }
}
