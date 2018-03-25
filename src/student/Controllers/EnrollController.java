package student.Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import student.Helpers.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpe20
 */
public class EnrollController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void insertEnroll(Integer student_id, Integer course_id, Integer batch_id, Integer major_id, Date date) {
        
        try {
            dbcon = Database.Connect();
            String sql = "Insert into enrolls (student_id, course_id, batch_id, major_id, date) values (?, ?, ?, ?, ?)";
            ps = dbcon.prepareStatement(sql);
            
            ps.setInt(1, student_id);
            ps.setInt(2, course_id);
            ps.setInt(3, batch_id);
            ps.setInt(4, major_id);
            ps.setDate(5, date);
            
            ps.executeUpdate();
            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally{
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
    }
    
    public Boolean seatsAvaliable(Integer batchid) {
        
        try {
            dbcon = Database.Connect();
            String sql = "select count(enrolls.id) as enrollcount, (select seats from batches where id = ?) as seats from enrolls where id = ?";
            ps = dbcon.prepareStatement(sql);
            ps.setInt(1, batchid);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getInt("seats"));
                if(rs.getInt("enrollCount") < rs.getInt("seats")) {
                    return true;
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {/* ignored */}
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {/* ignored */}
            }
            if (dbcon != null) {
                try {
                    dbcon.close();
                } catch (SQLException e) {/* ignored */}
            }
        }
        
        return false;
    }
    
    
}
