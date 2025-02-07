package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterUser {

    private Connection connection;

    public RegisterUser() throws SQLException {
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

    public boolean insertUsers(Register r) throws SQLException {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {

            String query = "insert into user (uname,uemail,upassword) values (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setString(2, r.getEmail());
            ps.setString(3, r.getPassword());

            int esito = ps.executeUpdate();

            if (esito == 1) {
                res = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
