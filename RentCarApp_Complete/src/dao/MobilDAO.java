
public class MobilDAO {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rentcar", "root", "");
    public void insert(Mobil m) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO mobil (plat, merk, status) VALUES (?, ?, ?)")) {
            stmt.setString(1, m.getPlat()); stmt.setString(2, m.getMerk()); stmt.setString(3, m.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
