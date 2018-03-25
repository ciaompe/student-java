
package student.Models;

public class Student{
    
    public int id;
    public String name;
    public String regid;
    public String address;
    public String contact;
    public String nic;
    public String dob;
    
    /**
     *
     * @param id
     * @param name
     * @param regid
     * @param address
     * @param contact
     * @param nic
     * @param dob
     */
    public Student(int id, String name, String regid, String address, String contact, String nic, String dob){
        this.id = id;
        this.name = name;
        this.regid = regid;
        this.address = address;
        this.contact = contact;
        this.nic = nic;
        this.dob = dob;
    }

}
