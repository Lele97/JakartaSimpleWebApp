package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUser {

    private Connection connection;

    public LoginUser() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean validate(String uemail, String upassword) throws SQLException {
        boolean status2 = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");

            PreparedStatement ps = con.prepareStatement("select * from user where uemail=? and upassword=?");
            ps.setString(1, uemail);
            ps.setString(2, upassword);

            ResultSet rs = ps.executeQuery();
            status2 = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return status2;
    }    
}   
