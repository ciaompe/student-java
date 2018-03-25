
package student.Helpers;

import java.sql.*;
import javax.swing.JOptionPane;


public class Database {
    
    public static Connection Connect() {
        
        try {
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\mpe20\\Desktop\\Student\\Student\\src\\school.sqlite");
            return conn;
        } 
        catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "SQL ERROR : "+ ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL ERROR : "+ ex);
        }
        
        return null;

    }
   
}
