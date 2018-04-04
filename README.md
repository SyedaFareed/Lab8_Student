# Lab8_Student

Create a DataBase using a relational database like SQL Server or MySql 
Create a Students Table with the following fields 
1-Name 
2-Registration Number 
3-Semester 
4-Address 

Develop a test application that can add 5 thousand students with random names and registration number using JDBC . 
Note the time the test application take to add the 5 thousand records. 

The application should do the above record insertion using first autocommit=false and then in other cycle with autocommit=true for all below cases

1) first time using Statement Class and note time,
2) then do the same work using Prepared Statement Class 
3) do the same work using batch update
4) then same work by writing database stored procedure and calling it using Callable Statement

Note: when one cycle of 5000 record insertion is complete. Truncate table before running the application using other technique.

Prepare the comparison table and see the time difference of same work using different techniques.

The first 3 options are  the part of the this Lab and for the 4th part work it as an assignement and submit the source code to the Class Instructor as well as the Table showing the results of each type of satement. 
