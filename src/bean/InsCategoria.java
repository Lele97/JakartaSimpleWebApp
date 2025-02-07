package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsCategoria {

    private Connection connection;

    public InsCategoria() throws SQLException {
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

    public boolean insertCategories(Category c) throws SQLException {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {

            String query = "insert into categories (code,description) values (?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, c.getCode());
            ps.setString(2, c.getDescription());

            int esitoc = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
