/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Models;

/**
 *
 * @author Admin
 */
public class StudentGrade {
    
    public String course;
    public String subject;
    public String grade;
            
    public StudentGrade(String course, String subject, String grade) {
        this.course = course;
        this.subject = subject;
        this.grade = grade;
    }
}
