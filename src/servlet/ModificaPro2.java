package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.ModProdotti;
import com.project.local.jakartasimplewebapp.bean.ProductID;
import com.project.local.jakartasimplewebapp.bean.ProductsDAO;
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
@WebServlet("/ModPro2")
public class ModificaPro2 extends HttpServlet {

    private static final long serialVersionUID = 8670968L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPro2() {
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

        String visualizza = request.getParameter("visualizza");

        if (visualizza != null) {

        } else {
            
            ProductsDAO productsDAO = null;
            try {
                productsDAO = new ProductsDAO();
            } catch (SQLException ex) {
                Logger.getLogger(ModificaPro2.class.getName()).log(Level.SEVERE, null, ex);
            }
            ModProdotti mc = null;
            try {
                mc = new ModProdotti();
            } catch (SQLException ex) {
                Logger.getLogger(ModificaPro2.class.getName()).log(Level.SEVERE, null, ex);
            }
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            ProductID c = new ProductID(Integer.parseInt(id), title, category, description);

            mc.updateProdotto(c);
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
