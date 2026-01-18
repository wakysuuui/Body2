import java.sql.*;

public class CharityDAO {

    // CREATE
    public static void insertCharity(Charity charity)
            throws SQLException {

        String sql =
                "INSERT INTO charity(name, purpose) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, charity.getName());
            ps.setString(2, charity.getPurpose());
            ps.executeUpdate();
        }
    }

    // READ
    public static void getAllCharities() throws SQLException {
        String sql = "SELECT * FROM charity";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("purpose")
                );
            }
        }
    }

    // UPDATE
    public static void updateCharityPurpose(int id, String purpose)
            throws SQLException {

        String sql =
                "UPDATE charity SET purpose = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, purpose);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    // DELETE
    public static void deleteCharity(int id) throws SQLException {
        String sql = "DELETE FROM charity WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
