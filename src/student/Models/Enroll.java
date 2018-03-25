/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Models;

import java.sql.Date;

/**
 *
 * @author mpe20
 */
public class Enroll {
    
    public Integer id;
    public Integer student_id;
    public Integer course_id;
    public Integer batch_id;
    public Integer major_id;
    public Date date;
    
    public Enroll(Integer id, Integer student_id, Integer course_id, Integer batch_id, Integer major_id, Date date) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.batch_id = batch_id;
        this.major_id = major_id;
        this.date = date;
    }
    
}
