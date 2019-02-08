
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import webbshopobjectoriented.Models.Order;

public class OrderRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    CustomerRepository cr = new CustomerRepository();
    
    public OrderRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public HashMap<Integer, Order> getOrders(String cust) {
        HashMap<Integer, Order> orders = new HashMap<>();

        query = "SELECT * FROM orders INNER JOIN customer ON customer.id = orders.customerID AND customer.name = ? AND orders.sent = 0";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setString(1, cust);
            rs = stmt.executeQuery();
            int count = 1;
            while (rs.next()) {
                Order order;
//                if (rs.getDate("lastUpdate") == null) {
//                    order = new Order(rs.getInt("id"),  rs.getDate("orderDate"), cr.getCustomerById(rs.getInt("id")), rs.getBoolean("sent"));
//                }
//                else {
                    order = new Order(rs.getInt("id"),  rs.getDate("orderDate"), rs.getDate("lastUpdate"), cr.getCustomerById(rs.getInt("customerID")), rs.getBoolean("sent"));
                //}
                orders.put(count, order);
                count++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return orders;
    }
    
    public int getOrderId(HashMap<Integer, Order> orders, String order) {
        if (order == null || order.equals("0"))
            return 0;
        else {
            return orders.get(Integer.parseInt(order)).getId();
        }
    }
}
