
@WebServlet("/MobilServlet")
public class MobilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String plat = request.getParameter("plat");
        String merk = request.getParameter("merk");
        MobilDAO dao = new MobilDAO();
        dao.insert(new Mobil(plat, merk, "tersedia"));
        response.sendRedirect("index.jsp");
    }
}
