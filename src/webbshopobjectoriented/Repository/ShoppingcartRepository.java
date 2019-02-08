
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;
import webbshopobjectoriented.Models.Customer;
import webbshopobjectoriented.Models.Order;

public class ShoppingcartRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    CustomerRepository cr = new CustomerRepository();
    ShoesRepository sr = new ShoesRepository();
    OrderRepository or = new OrderRepository();
    
    public ShoppingcartRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String AddProductToCart(HashMap<Integer, Order> orders, String customer, String product, String order) {        
        query = "{CALL AddToCart(?, ?, ?)}";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                CallableStatement addToCartStatement = con.prepareCall(query)) {
                        
            if (order.equals("Ny order"))
                order = null;
            
            addToCartStatement.setInt(1, cr.getCustomerId(customer));
            addToCartStatement.setInt(2, or.getOrderId(orders, order));
            addToCartStatement.setInt(3, sr.getProductId(product));            
            addToCartStatement.execute();
            
            ResultSet addToCartResult = addToCartStatement.getResultSet();
                        
            if (addToCartResult != null) {
                while (addToCartResult.next()) {
                    System.out.println(addToCartResult.getString("error"));
                    System.out.println("Detta felmeddelande kan bero på ett tomt lagersaldo!");
                }    
            }
            else {
                return product + " har blivit tillagd till order [" + order + "] för kund " + customer;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "Ordern kunde inte läggas till.";
    }
}
