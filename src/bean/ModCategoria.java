package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModCategoria {

    private Connection connection;

    public ModCategoria() throws SQLException {
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

    public boolean updateCategoria(CategoryID cid) {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {
            
            
            String query = "UPDATE categories set code =? , description =? where id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, cid.getCode());
            ps.setString(2, cid.getDescription());
            ps.setInt(3, cid.getId());
            
            int esitou = ps.executeUpdate();
            
            if(esitou == 1) {
                res = true;
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
}
