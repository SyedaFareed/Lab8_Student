/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_student;

import java.sql.*;

/**
 *
 * @author Dell
 */
public class Lab8_Student {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Db d= new Db();
        
        //d.insert_stmt(false);
        //d.insert_stmt(true);
        
        //d.insert_preps(false);
        //d.insert_preps(true);
        
        //d.insert_batch(false);
        //d.insert_batch(true);
        
        //d.insert_call(false);
        d.insert_call(true);
    }
    
}