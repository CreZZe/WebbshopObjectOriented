
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;
import webbshopobjectoriented.Models.Shoes;

public class ShoesRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    
    CategoryRepository cr = new CategoryRepository();
    LabelRepository lr = new LabelRepository();
    
    public ShoesRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public HashMap<Integer, Shoes> getProducts() {
        HashMap<Integer, Shoes> productList = new HashMap<>();
        

        query = "SELECT shoes.id, shoes.name, shoes.shoeSize, shoes.color, shoes.price, shoes.quantityInStore, label.id, category.id FROM shoes "
                + " INNER JOIN label "
                + " ON label.id = shoes.labelID "
                + " INNER JOIN category "
                + " ON category.id = shoes.categoryID ";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Shoes shoes = new Shoes(rs.getInt("shoes.id"), rs.getString("name"), rs.getInt("shoeSize"), rs.getString("color"), 
                        rs.getDouble("price"), rs.getInt("quantityInStore"), lr.getLabelById(rs.getInt("label.id")), cr.getCategoryById(rs.getInt("category.id")));
                productList.put(rs.getInt("id"), shoes);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return productList;
    }
    
    public int getProductId(String input) {
        query = "SELECT id FROM Shoes WHERE name = ?";
        
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
