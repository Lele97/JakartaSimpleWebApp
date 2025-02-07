package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductsDAO {
    private Connection connection;
    public ProductsDAO() throws SQLException {
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

    
    public List<ProductID> getProducts(){
         List<ProductID> productsid = new ArrayList<>();
    
        try ( Statement statement = connection.createStatement()) {

            ResultSet resultset = statement.executeQuery("SELECT * FROM products");
             while(resultset.next()){
            	 ProductID p = new ProductID(
                    resultset.getInt("id"),
                    resultset.getString("title"),
                    resultset.getString("category"),
                    resultset.getString("description")
                 );
            	 productsid.add(p);
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsid;
    }
    public static Logger getLog() {
		return LOG;
	}
	private static final Logger LOG = Logger.getLogger(ProductsDAO.class.getName());

}
