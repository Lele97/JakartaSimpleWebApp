package servlet;

import bean.InsProdotti;
import bean.Product;
import bean.ProductsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class CategorieVis
 */
@WebServlet("/InsPro2")
public class InserisciPro2 extends HttpServlet {

    private static final long serialVersionUID = 678686L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciPro2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();
        String pluto = request.getParameter("pluto");

        if (pluto != null) {

        } else {

            ProductsDAO productsDAO = null;
            InsProdotti mc = null;

            try {
                productsDAO = new ProductsDAO();
                mc = new InsProdotti();

            } catch (SQLException e) {
                // TODO Auto-generated catch block

            }

            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String description = request.getParameter("description");

            Product c = new Product(title, category, description);

            try {
                boolean esito = mc.insertProducts(c);
            } catch (SQLException ex) {

                Logger.getLogger(InserisciPro2.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("products", productsDAO.getProducts());
            request.getRequestDispatcher("/vistaProdotto").forward(request, response);
        }
    }

    /**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
