package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.CategoriesDAO;
import com.project.local.jakartasimplewebapp.bean.Category;
import com.project.local.jakartasimplewebapp.bean.InsCategoria;
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
@WebServlet("/InsCa2")
public class InserisciCa2 extends HttpServlet {

    private static final long serialVersionUID = 67868768L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciCa2() {
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

        String pippo = request.getParameter("pippo");

        if (pippo != null) {

        } else {
            try {
                CategoriesDAO categoriesDAO = null;
                InsCategoria mc = null;
                try {
                    categoriesDAO = new CategoriesDAO();
                    mc = new InsCategoria();
                    
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    
                }
                
                String codice = request.getParameter("codice");
                String descrizione = request.getParameter("descrizione");
                
                Category c = new Category(codice, descrizione);
                
                
                boolean esitoc = mc.insertCategories(c);
                
                request.setAttribute("categories", categoriesDAO.getCategories());
                request.getRequestDispatcher("/vistaCategoria").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(InserisciCa2.class.getName()).log(Level.SEVERE, null, ex);
                // TODO Auto-generated catch block

            }

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
