package com.project.local.jakartasimplewebapp.bean;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModProdotti {

    private Connection connection;

    public ModProdotti() throws SQLException {
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

    public boolean updateProdotto(ProductID c) {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {
            
            
            String query = "UPDATE products set title =? , category=?, description =? where id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getCategory());
            ps.setString(3, c.getDescription());
            ps.setInt(4, c.getId());
            
            int esito = ps.executeUpdate();
            
            if(esito == 1) {
                res = true;
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static Logger getLog() {
        return LOG;
    }
    private static final Logger LOG = Logger.getLogger(ProductsDAO.class.getName());

}
