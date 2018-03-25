package student.Controllers;

import student.Models.Student;
import student.Helpers.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.Models.Course;

public class StudentController {
    
    Connection dbcon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public StudentController() {

    }

    public Student searchById(int id){
        try {
            dbcon = Database.Connect();
            String sql = "select * from students where id = ?";
            ps = dbcon.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("regid"),
                    rs.getString("address"),
                    rs.getString("contact"),
                    rs.getString("nic"),
                    rs.getString("dob")
                );
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
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList allStudents() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            dbcon = Database.Connect();
            String sql = "select * from students";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("regid"),
                    rs.getString("address"),
                    rs.getString("contact"),
                    rs.getString("nic"),
                    rs.getString("dob")
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
    
    public Integer nextStudentId() {
        try {
            dbcon = Database.Connect();
            String sql = "select max(id) as id  from students";
            ps = dbcon.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               System.out.println(rs.getInt("id"));
               return rs.getInt("id");
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
        return 0;
    }
    
    
    public void insertStudent(String regid, String name, String address, String contact, String nic, String dob) {
        try {
            dbcon = Database.Connect();
            String sql = "Insert into students (name, regid, address, contact, nic, dob) values (?, ?, ?, ?, ?, ?)";
            ps = dbcon.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, regid);
            ps.setString(3, address);
            ps.setString(4, contact);
            ps.setString(5, nic);
            ps.setString(6, dob);
            
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
    
    public ArrayList studentCourseList(Integer bachid) {
        ArrayList<Course> list = new ArrayList<Course>();
         
         try {
            dbcon = Database.Connect();
            String sql = "select courses.id, courses.name, courses.desc from enrolls inner join courses on enrolls.course_id = courses.id where student_id = ?";
            ps = dbcon.prepareStatement(sql);
            ps.setInt(1, bachid);
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
