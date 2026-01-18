import java.sql.*;

public class DonorDAO {

    public static void insertDonor(Donor donor) throws SQLException {
        String sql =
                "INSERT INTO donor(name, age, email) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, donor.getName());
            ps.setInt(2, donor.getAge());
            ps.setString(3, donor.getEmail());
            ps.executeUpdate();
        }
    }

    public static void getAllDonors() throws SQLException {
        String sql = "SELECT * FROM donor";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("email")
                );
            }
        }
    }

    public static void updateDonorEmail(int id, String email)
            throws SQLException {

        String sql =
                "UPDATE donor SET email = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public static void deleteDonor(int id) throws SQLException {
        String sql = "DELETE FROM donor WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
