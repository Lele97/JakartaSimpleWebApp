package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriesDAO {

    private Connection connection;

    public CategoriesDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<CategoryID> getCategories() {
        List<CategoryID> categoriesid = new ArrayList<>();

        try ( Statement statement = connection.createStatement()) {
            
            ResultSet resultset = statement.executeQuery("SELECT * FROM categories");
            while (resultset.next()) {
                CategoryID cid = new CategoryID(
                        resultset.getInt("id"),
                        resultset.getString("code"),
                        resultset.getString("description")
                );
                categoriesid.add(cid);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoriesid;
    }

    public static Logger getLog() {
        return LOG;
    }
    private static final Logger LOG = Logger.getLogger(CategoriesDAO.class.getName());

}
