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
public class User {
    
    protected int id;
    protected String username;
    protected String password;
    protected String role;
    
    public User(int uid, String uname, String upw, String urole) {
        id = uid;
        username = uname;
        password = upw;
        role = urole;
    }
    
    public int getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
}
