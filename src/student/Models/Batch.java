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
public class Batch {
    
    public Integer id;
    public String number;
    public Integer seats;
    public Integer course_id;
    public Date date;
    
    public Batch(Integer id, String number, Integer seats, Integer course_id, Date date) {
        this.id = id;
        this.number = number;
        this.seats = seats;
        this.course_id = course_id;
        this.date = date;
    }
    
    
}
