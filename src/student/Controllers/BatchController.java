package student.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.Helpers.Database;
import student.Models.Batch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpe20
 */
public class BatchController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void insertBatch(String number, Integer seats, Integer course_id, Date date) {
        try {
            dbcon = Database.Connect();
            String sql = "Insert into batches (number, seats, course_id, date) values (?, ?, ?)";
            ps = dbcon.prepareStatement(sql);
            ps.setString(1, number);
            ps.setInt(2, seats);
            ps.setInt(2, course_id);
            ps.setDate(3, date);
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
    
    public ArrayList allBatches() {
        ArrayList<Batch> list = new ArrayList<Batch>();
        try {
            dbcon = Database.Connect();
            String sql = "select * from batches";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Batch(
                    rs.getInt("id"),
                    rs.getString("number"),
                    rs.getInt("seats"),
                    rs.getInt("course_id"),
                    rs.getDate("date")
                ));
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
        return list;
    }
   
    
    
    
}
