package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.CategoriesDAO;
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
@WebServlet("/vistaCategoria")
public class CategorieVis extends HttpServlet {

    private static final long serialVersionUID = 5678L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieVis() {
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
    @SuppressWarnings("null")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HttpSession currentSession = request.getSession();

        String nanam = request.getParameter("nanam");
        if (nanam != null) {

        } else {
        CategoriesDAO categoriesDAO = null;
        try {
            categoriesDAO = new CategoriesDAO();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieVis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("categories", categoriesDAO.getCategories());
        }
        request.getRequestDispatcher("vistaCategorie.jsp").forward(request, response);
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
