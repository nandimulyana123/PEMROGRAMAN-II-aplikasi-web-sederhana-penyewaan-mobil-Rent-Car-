
public class TransaksiDAO {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rentcar", "root", "");
    public void sewaMobil(int idMobil, int idCustomer, Date tglSewa, Date tglKembaliEst) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO transaksi (id_mobil, id_customer, tgl_sewa, tgl_kembali_est) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, idMobil); stmt.setInt(2, idCustomer); stmt.setDate(3, tglSewa); stmt.setDate(4, tglKembaliEst);
            stmt.executeUpdate();
            conn.prepareStatement("UPDATE mobil SET status='disewa' WHERE id=" + idMobil).executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void kembalikanMobil(int id, Date kembali) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE transaksi SET tgl_kembali_aktual=?, denda=? WHERE id=?");
            stmt.setDate(1, kembali); stmt.setInt(2, 0); stmt.setInt(3, id); stmt.executeUpdate();
            // denda bisa dihitung berdasarkan selisih tanggal
        } catch (Exception e) { e.printStackTrace(); }
    }
}
