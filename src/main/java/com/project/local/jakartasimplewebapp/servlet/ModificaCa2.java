package servlet;

import bean.CategoriesDAO;
import bean.CategoryID;
import bean.ModCategoria;
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
@WebServlet("/ModCa2")
public class ModificaCa2 extends HttpServlet {

    private static final long serialVersionUID = 876868L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCa2() {
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

        String visualizza = request.getParameter("visualizza");

        if (visualizza != null) {
            
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            
            CategoriesDAO categoriesDAO = null;
            try {
                categoriesDAO = new CategoriesDAO();
            } catch (SQLException ex) {
                Logger.getLogger(ModificaCa2.class.getName()).log(Level.SEVERE, null, ex);
            }
            ModCategoria mc = null;
            try {
                mc = new ModCategoria();
            } catch (SQLException ex) {
                Logger.getLogger(ModificaCa2.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            
            CategoryID cid = new CategoryID(id, code, description);
            mc.updateCategoria(cid);

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
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
