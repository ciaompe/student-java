package student.Controllers;

import student.Helpers.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.Helpers.Hash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpe20
 */
public class UserController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public UserController() {
        
    }
    
    public boolean login(String username, String password) {
        try {
            dbcon = Database.Connect();
            String sql = "select * from users where username = ?";
            ps = dbcon.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            //while has username then check users password
            while(rs.next()){
                return Hash.passwordVerify(password, rs.getString("password"));
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (dbcon != null) {
                try {
                    dbcon.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return false;
    }

    
}
