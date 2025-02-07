package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DelProdotti {

    private Connection connection;

    public DelProdotti() throws SQLException {
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

    public boolean delProducts(DelId c) {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {
            
            
            String query = "delete from products where id=?";
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
