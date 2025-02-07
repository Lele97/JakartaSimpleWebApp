package servlet;

import bean.CategoriesDAO;
import bean.DelCategoria;
import bean.DelId;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class CategorieVis
 */
@WebServlet("/DelCa")
public class EliminaCa extends HttpServlet {

    private static final long serialVersionUID = 8768L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaCa() {
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
        String elimina = request.getParameter("elimina");

        if (elimina != null) {
            
        } else {
            CategoriesDAO categoriesDAO = null;
            DelCategoria mc = null;
            try {

                categoriesDAO = new CategoriesDAO();
                mc = new DelCategoria();
            } catch (SQLException e) {
            }
            int id = Integer.parseInt(request.getParameter("id"));

            DelId c = new DelId(id);

            boolean esito = mc.delCategories(c);

            request.setAttribute("categories", categoriesDAO.getCategories());

            request.getRequestDispatcher("/vistaCategoria").forward(request, response);
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

        doGet(request, response);
    }

}
