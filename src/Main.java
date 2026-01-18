import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/charity_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0000";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            System.out.println("DONORS:");
            System.out.println("ID | Name | Age | Email");

            ResultSet donors =
                    stmt.executeQuery("SELECT * FROM donor");

            while (donors.next()) {
                System.out.println(
                        donors.getInt("id") + " | " +
                                donors.getString("name") + " | " +
                                donors.getInt("age") + " | " +
                                donors.getString("email")
                );
            }

            System.out.println();

            System.out.println("CHARITIES:");
            System.out.println("ID | Name | Purpose");

            ResultSet charities =
                    stmt.executeQuery("SELECT * FROM charity");

            while (charities.next()) {
                System.out.println(
                        charities.getInt("id") + " | " +
                                charities.getString("name") + " | " +
                                charities.getString("purpose")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
