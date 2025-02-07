package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryList {
    private Connection connection;

    public CategoryList() throws SQLException {
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
    

    public List<CategoryDrop> DropCategories() {
        List<CategoryDrop> categorieslist = new ArrayList<>();

        try ( Statement statement = connection.createStatement()) {
           
            ResultSet resultset = statement.executeQuery("SELECT * FROM categories");
            while (resultset.next()) {
                CategoryDrop drop = new CategoryDrop(                        
                        resultset.getInt("id"),
                        resultset.getString("code")
                );
                categorieslist.add(drop);
                }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorieslist;
    }

    public static Logger getLog() {
        return LOG;
    }
    private static final Logger LOG = Logger.getLogger(CategoriesDAO.class.getName());

}

