package servlet;

import java.io.IOException;
import java.sql.SQLException;

import bean.ProductsDAO;


/**
 * Servlet implementation class CategorieVis
 */
@WebServlet("/vistaProdotto")
public class ProdottiVis extends HttpServlet {

    private static final long serialVersionUID = 8546L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiVis() {
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
        // TODO Auto-generated method stub
        HttpSession currentSession = request.getSession();
        ProductsDAO productsDAO = null;
        try {
            productsDAO = new ProductsDAO();
        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }


        request.setAttribute("products", productsDAO.getProducts());
        request.getRequestDispatcher("vistaProdotti.jsp").forward(request, response);

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
