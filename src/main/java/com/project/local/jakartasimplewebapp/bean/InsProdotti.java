package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsProdotti {

    private Connection connection;

    public InsProdotti() throws SQLException {
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

    public boolean insertProducts(Product c) throws SQLException {
        boolean res = false;

        try ( Statement statement = connection.createStatement()) {        
                       
            String query ="insert into products (title,category,description) values (?,?,?)";           
            
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getCategory());
            ps.setString(3, c.getDescription());
            
        int esito = ps.executeUpdate();
            
            if(esito == 1) {
                res = true;
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}

