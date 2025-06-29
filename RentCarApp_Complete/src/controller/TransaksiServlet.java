
@WebServlet("/TransaksiServlet")
public class TransaksiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TransaksiDAO dao = new TransaksiDAO();
        String aksi = request.getParameter("aksi");
        if ("Sewa".equals(aksi)) {
            int idMobil = Integer.parseInt(request.getParameter("id_mobil"));
            int idCustomer = Integer.parseInt(request.getParameter("id_customer"));
            Date tglSewa = Date.valueOf(request.getParameter("tgl_sewa"));
            Date tglKembaliEst = Date.valueOf(request.getParameter("tgl_kembali_est"));
            dao.sewaMobil(idMobil, idCustomer, tglSewa, tglKembaliEst);
        } else if ("Kembalikan".equals(aksi)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Date kembali = Date.valueOf(request.getParameter("tgl_kembali_aktual"));
            dao.kembalikanMobil(id, kembali);
        }
        response.sendRedirect("index.jsp");
    }
}
