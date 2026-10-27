
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pmis";
        String username = "root";
        String password = "manager";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            System.out.println("Database connected successfully!");

            con.close();
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
}
