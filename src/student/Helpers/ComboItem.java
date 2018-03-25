/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Helpers;

/**
 *
 * @author mpe20
 */
public class ComboItem {
    public final String key;
    public final String value;

    public ComboItem(String value, String key)
    {
        this.value = value;
        this.key = key;
    }
    
    @Override
    public String toString() {
        return value;
    }

    public String getKey()
    {
        return value;
    }

    public String getValue()
    {
        return key;
    }
    
}
