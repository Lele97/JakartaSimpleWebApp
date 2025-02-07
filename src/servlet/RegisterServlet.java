package com.project.local.jakartasimplewebapp.servlet;


import com.project.local.jakartasimplewebapp.bean.LoginUser;
import com.project.local.jakartasimplewebapp.bean.Register;
import com.project.local.jakartasimplewebapp.bean.RegisterUser;
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
 *
 * @author user
 */
@WebServlet("/RecUser")
public class RegisterServlet extends jakarta.servlet.http.HttpServlet {

    private static final long serialVersionUID = 6783L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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

        String paperino = request.getParameter("paperino");

        if (paperino != null) {

        } else {

            RegisterUser mc = null;
            try {
                RegisterUser registeruser = new RegisterUser();
                mc = new RegisterUser();
            } catch (SQLException e) {
                // TODO Auto-generated catch block

            }

            String uname = request.getParameter("uname");
            String uemail = request.getParameter("uemail");
            String upassword = request.getParameter("upassword");

            Register r = new Register(uname, uemail, upassword);

            
            try {
                boolean esito = mc.insertUsers(r);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


            String mail = request.getParameter("uemail");
            String pass = request.getParameter("upassword");
        try {
            if (LoginUser.validate(mail, pass)) {
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession currentSession = request.getSession();
                currentSession.setAttribute("uemail", mail);
                currentSession.setMaxInactiveInterval(60 * 60);
                request.getRequestDispatcher("/home.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }           

        }
        /**
         * String name = request.getParameter("uname"); String email =
         * request.getParameter("uemail"); String password =
         * request.getParameter("upassword");
         *
         * Register register = new Register(); register.setName(name);
         * register.setEmail(email); register.setPassword(password);
         *
         * RegisterUser db = null; try { db = new RegisterUser(); } catch
         * (SQLException ex) {
         * Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE,
         * null, ex); } try { db.insertUsers(register); } catch (SQLException
         * ex) {
         * Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE,
         * null, ex); }
         */
            
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
