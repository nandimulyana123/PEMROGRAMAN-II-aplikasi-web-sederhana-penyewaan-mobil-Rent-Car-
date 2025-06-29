
public class CustomerDAO {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rentcar", "root", "");
    public void insert(Customer c) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (nama, alamat) VALUES (?, ?)")) {
            stmt.setString(1, c.getNama()); stmt.setString(2, c.getAlamat());
            stmt.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
