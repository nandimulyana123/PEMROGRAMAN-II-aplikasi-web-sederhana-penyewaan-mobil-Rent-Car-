
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        CustomerDAO dao = new CustomerDAO();
        dao.insert(new Customer(nama, alamat));
        response.sendRedirect("index.jsp");
    }
}
