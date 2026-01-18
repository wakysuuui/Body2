import java.sql.*;

public class DonationDAO {

    public static void insertDonation(Donation donation)
            throws SQLException {

        String sql =
                "INSERT INTO donation(amount) VALUES (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, donation.getAmount());
            ps.executeUpdate();
        }
    }

    public static void getAllDonations() throws SQLException {
        String sql = "SELECT * FROM donation";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getDouble("amount")
                );
            }
        }
    }

    public static void updateDonationAmount(int id, double amount)
            throws SQLException {

        String sql =
                "UPDATE donation SET amount = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public static void deleteDonation(int id) throws SQLException {
        String sql = "DELETE FROM donation WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
