package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DelCategoria {

    private Connection connection;

    public DelCategoria() throws SQLException {
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino","root", "");
       try {
           this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazzino", "root", "");
            }catch (SQLException ex) {
                Logger.getLogger(ProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }  
    
    public boolean delCategories(DelId c) {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {
            
            
            String query = "delete from categories where id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, c.setId());
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
