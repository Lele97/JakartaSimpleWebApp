package servlet;

import bean.LoginUser;
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

@WebServlet("/LogUser")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 6548L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
/*                response.sendRedirect("home.jsp");*/
                request.getRequestDispatcher("/home.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    /** prova cookie
     *  String name = request.getParameter("uname");
        String pass = request.getParameter("upassword");
        try {
            if (LoginUser.validate(name, pass)) {
                Cookie c = new Cookie(name, pass);
                response.addCookie(c);       
            }
        request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/ /** porva2 cookie
    String mail = request.getParameter("uemail");
    String pass = request.getParameter("upassword");
        try {
            if (LoginUser.validate(mail, pass)) {
                String name = request.getParameter("uname");
                Cookie ck = new Cookie("uname" , name);
                response.addCookie(ck);
                Cookie cks[] = request.getCookies();
                for(int i = 0; i < cks.length; i++){}
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
