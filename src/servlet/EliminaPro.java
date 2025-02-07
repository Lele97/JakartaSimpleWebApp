package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.DelId;
import com.project.local.jakartasimplewebapp.bean.DelProdotti;
import com.project.local.jakartasimplewebapp.bean.ProductsDAO;
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
@WebServlet("/DelPro")
public class EliminaPro extends HttpServlet {

    private static final long serialVersionUID = 68768L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaPro() {
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
            ProductsDAO productsDAO = null;
            DelProdotti mc = null;
            try {

                productsDAO = new ProductsDAO();
                mc = new DelProdotti();
            } catch (SQLException e) {
            }
            int id = Integer.parseInt(request.getParameter("id"));

            DelId c = new DelId(id);

            boolean esito = mc.delProducts(c);
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
