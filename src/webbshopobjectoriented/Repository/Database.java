
package webbshopobjectoriented.Repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    Connection con;
    public void setupDatabaseConnection() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/webbshop/Settings.properties"));
            
            // Manually loading the Java Database Connection driver.
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(p.getProperty("connectionString"), 
                                              p.getProperty("name"), 
                                              p.getProperty("password"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeDatabaseConnection() {
        try {
            if (con != null)
                con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
