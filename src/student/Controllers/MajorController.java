package student.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.Helpers.Database;
import student.Models.Major;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpe20
 */
public class MajorController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
     public ArrayList allMajors() {
        ArrayList<Major> list = new ArrayList<Major>();

        try {
            dbcon = Database.Connect();
            String sql = "select * from majors";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Major(
                    rs.getInt("id"),
                    rs.getString("name")
                ));
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
        return list;
    }
    
}
