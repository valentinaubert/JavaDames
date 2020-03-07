package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author p1810879
 */
public class bddConnexion {
      
    private static String dbUrl = "";
    private static String dbUser = " ";
    private static String dbPassword = " ";
    private static String query = " ";
    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException
    {       
        if(conn != null)
        {
            return conn;
        }else {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return conn;
        }        
    }
    
    public static ResultSet getRequest(String query) throws SQLException
    {
        Statement  stmt = null;
        ResultSet rs = null;
        stmt.getConnection().prepareStatement(query);
        rs = stmt.executeQuery(query);
        return rs;
    }
    
    
    
}
