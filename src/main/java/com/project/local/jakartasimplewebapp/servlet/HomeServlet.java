package servlet;

import bean.CategoriesDAO;
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

@WebServlet("/Home")
public class HomeServlet extends jakarta.servlet.http.HttpServlet {

    private static final long serialVersionUID = 89707899L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
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
    @SuppressWarnings("null")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();
        String nanan = request.getParameter("nanan");

        if (nanan != null) {

        } else {
            ProductsDAO productsDAO = null;
            try {
                productsDAO = new ProductsDAO();
            } catch (SQLException ex) {
                Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            CategoriesDAO categoriesDAO = null;
            try {
                categoriesDAO = new CategoriesDAO();
            } catch (SQLException ex) {
                Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("products", productsDAO.getProducts());
            request.setAttribute("categories", categoriesDAO.getCategories());
        }
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response) HttpSession session = request.getSession(false); if (session !=
     * null) {      *
     * } else { request.getRequestDispatcher("/LogUser").include(request,
     * response); }
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
