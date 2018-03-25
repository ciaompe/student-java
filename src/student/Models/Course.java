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
public class Course {
   public Integer id;
   public String name;
   public String desc;
   
   public Course(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
   }
    
}
