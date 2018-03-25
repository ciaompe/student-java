/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.Helpers.Database;
import student.Models.Course;

/**
 *
 * @author Admin
 */
public class CourseController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void insertCourse(String name, String desc) {
        try {
            dbcon = Database.Connect();
            String sql = "Insert into courses (name, desc) values (?, ?)";
            ps = dbcon.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, desc);       
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
    
    public ArrayList allCourses() {
        ArrayList<Course> list = new ArrayList<Course>();

        try {
            dbcon = Database.Connect();
            String sql = "select * from courses";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Course(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("desc")
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
