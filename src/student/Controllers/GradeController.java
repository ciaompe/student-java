package student.Controllers;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.Helpers.Database;
import student.Models.Grade;
import student.Models.Student;
import student.Models.StudentGrade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpe20
 */
public class GradeController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void insertGrade(String grade, Integer course_id, Integer student_id, Integer subject_id) {
        try {
            dbcon = Database.Connect();
            String sql = "Insert into grades (grade, course_id, student_id, subject_id) values (?, ?, ?, ?)";
            ps = dbcon.prepareStatement(sql);
            ps.setString(1, grade);
            ps.setInt(2, course_id);
            ps.setInt(3, student_id);
            ps.setInt(4, subject_id);
            
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
    
    
    public ArrayList gradeAll() {
        ArrayList<Grade> list = new ArrayList<Grade>();
         
        try {
            dbcon = Database.Connect();
            String sql = "select * from grades";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Grade(
                    rs.getInt("id"),
                    rs.getString("grade"),
                    rs.getInt("course_id"),
                    rs.getInt("student_id"),
                    rs.getInt("subject_id")
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
    
    public ArrayList gradeByStu(Integer batchid) {
        
        ArrayList<StudentGrade> list = new ArrayList<StudentGrade>();
        
        try {
            dbcon = Database.Connect();
            String sql = "select grades.grade as grade, courses.name as course, subjects.name as subject from grades inner join courses on grades.course_id = courses.id inner join subjects on grades.subject_id = subjects.id where grades.student_id = ?";
            ps = dbcon.prepareStatement(sql);
            ps.setInt(1, batchid);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new StudentGrade(
                   rs.getString("course"),
                   rs.getString("subject"),
                   rs.getString("grade")
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
