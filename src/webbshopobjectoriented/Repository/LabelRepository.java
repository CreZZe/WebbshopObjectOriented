
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import webbshopobjectoriented.Models.Label;

public class LabelRepository {
    Database db = new Database();
    Properties p = new Properties();
    String query;
    ResultSet rs;
    
    public LabelRepository() {
        try {
            p.load(new FileInputStream("src/webbshopobjectoriented/repository/Settings.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public Label getLabelById(int id) {
        Label label = null;

        query = "SELECT * FROM label WHERE id = ? ";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
            p.getProperty("name"),
            p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                label = new Label(rs.getInt("id"), rs.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return label;
    }
}
