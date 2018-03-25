/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Models;
/**
 *
 * @author mpe20
 */
public class Grade {
    
    public Integer id;
    public String grade;
    public Integer course_id;
    public Integer student_id;
    public Integer subject_id;
    
    public Grade(Integer id, String grade, Integer course_id, Integer student_id, Integer subject_id) {
        this.id = id;
        this.grade = grade;
        this.course_id = course_id;
        this.student_id = student_id;
        this.subject_id = subject_id;
    }
    
   
}
