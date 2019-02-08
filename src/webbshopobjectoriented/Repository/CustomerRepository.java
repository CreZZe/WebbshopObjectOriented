
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;
import webbshopobjectoriented.Models.Customer;

public class CustomerRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    
    public CustomerRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public HashMap<Integer, Customer> getCustomers() {
        HashMap<Integer, Customer> customers = new HashMap<>();

        query = "SELECT * FROM customer";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Customer cust = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
                customers.put(rs.getInt("id"), cust);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return customers;
    }
    
    public Customer getCustomerById(int id) {
        Customer customer = null;
        query = "SELECT * FROM customer WHERE id = ?";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return customer;
    }
    
    public int getCustomerId(String input) {
        query = "SELECT id FROM customer WHERE name = ?";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setString(1, input);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                return rs.getInt("id");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return -1;
    }
}
