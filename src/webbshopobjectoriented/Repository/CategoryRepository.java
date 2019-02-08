
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import webbshopobjectoriented.Models.Category;

public class CategoryRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    
    public CategoryRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Category getCategoryById(int id) {
        Category category = null;

        query = "SELECT * FROM category WHERE id = ? ";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return category;
    }
}
