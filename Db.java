/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author Dell
 */
public class Db {
    Connection con= null;
    Statement stmt= null;
    PreparedStatement preps= null;
    CallableStatement cstmt= null;
    Random rand;
    
    Db(){
      try{
	      //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "root");
                
                //con.close(); 
      }
            
      catch(Exception i){
          System.out.println(i);    //print exception
      }
      
      rand = new Random();
    }   //end constructor 
    
    public void insert_stmt(Boolean x){

        
        try{
            con.setAutoCommit(x);
            stmt = con.createStatement();
            Boolean ret;
            int temp;

            String query= "";
            int  regno = 0;

            for(int i=0; i<5000; i++){
                regno = rand.nextInt(5000) + 1;  
                query= "INSERT INTO `lab8_student`.`students` (`regno`, `name`) VALUES ('"+regno+"', 'a"+regno+"')";
                ret = stmt.execute(query);

            }
            
            if(x==false)
                con.commit();
            
            stmt.close();
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally{
      //finally block used to close resources
          try{
             if(stmt!=null)
                stmt.close();
             if(con!=null)
                con.close();
          }catch(Exception se){
             se.printStackTrace();}
      }//end finally try
    }   //end function
    
    
    
    
    
    
    
    public void insert_preps(Boolean x){
        try{
            con.setAutoCommit(x);
            
            stmt = con.createStatement();
            Boolean ret;
            int temp;

            String query= "";
            int  regno = 0;

            for(int i=0; i<5000; i++){
                regno = rand.nextInt(5000) + 1;  

                query= "INSERT INTO `lab8_student`.`students` (`regno`, `name`) VALUES (?,?)";
                preps = con.prepareStatement(query);
                preps.setInt(1, regno);  // This would set age
                preps.setString(2, "a"+regno); // This would set ID
                temp = preps.executeUpdate();

            }
            
            if(x==false)
                con.commit();            
            
            preps.close();    
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally{
      //finally block used to close resources
          try{
              if(preps!=null)
                preps.close();
             if(con!=null)
                con.close();
          }catch(Exception se){
             se.printStackTrace();}
      }//end finally try
    }   //end function
    
    
    
    public void insert_batch(Boolean x){

        try{
            
            con.setAutoCommit(x);            
            stmt = con.createStatement();
            Boolean ret;

            String query= "";
            int  regno = 0;

            for(int i=0; i<5000; i++){
                regno = rand.nextInt(5000) + 1;  
                query= "INSERT INTO `lab8_student`.`students` (`regno`, `name`) VALUES ('"+regno+"', 'a"+regno+"')";
                stmt.addBatch(query);

            }
            
            int[] count = stmt.executeBatch();
            
            if(x==false)
                con.commit();
            
            stmt.close();
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally{
      //finally block used to close resources
          try{
             if(stmt!=null)
                stmt.close();
          }catch(Exception se){
             se.printStackTrace();}
      }//end finally try
    }   //end function    
    
public void insert_call(Boolean x){
    try{ 
        con.setAutoCommit(x);

        int  regno = 0;

        String sql= "{CALL `lab8_student`.`insert`(?, ?)}";

        //String sql = "{call `lab8_student`.'insert' (?, ?)}";
        cstmt = con.prepareCall(sql);

        for(int i=0; i<5000; i++){
            regno = rand.nextInt(5000) + 1;  
            //Bind IN the two parameters
            cstmt.setInt(1, regno); 
            cstmt.setString(2, "a"+regno); 
            cstmt.execute();        
        }
        
        if(x==false)
            con.commit();
        
        cstmt.close();
        con.close();

    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
        //finally block used to close resources
        try{
        if (cstmt!=null) {
            cstmt.close();
        }}catch(SQLException se2){
      }// nothing we can do
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
}
   }    //end function insert_call
    
    


}
