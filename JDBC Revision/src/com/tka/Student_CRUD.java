package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Student_CRUD {
	private static final String url = "jdbc:mysql://localhost:3306/203_J2EE";
    private static final String username = "root";
    private static final String password = "aditi@2003";
    
    public static Connection getDbConnection() {
    	Connection con=null;;
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection(url, username, password);
    		System.out.println("connection established");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
    
    public static int insertintodb() 
    {
    	int i=0;
    	try {
      Statement stmt=getDbConnection().createStatement();
      String sql="insert into student values(2, 'Sumit', 35 )";
      i=stmt.executeUpdate(sql);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		return i;
    }
    
    public static int deleteintodb() 
    {
    	int i=0;
    	try {
      Statement stmt=getDbConnection().createStatement();
      String sql="delete from student where id=2";
      i=stmt.executeUpdate(sql);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		return i;
    }
    
    public static int viewStudent() 
    {
    	int i=0;
    	try {
      Statement stmt=getDbConnection().createStatement();
      String sql="select * from student";
      ResultSet rs=stmt.executeQuery(sql);
    	while(rs.next()) {
    		int id=rs.getInt(1);
    		String name = rs.getString(2);
    		int age= rs.getInt(3);
    		System.out.println("id =" +id+"name ="+name+" Age = "+age);
    	}
    	
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
		return i;
    }
    
    
    public static void main(String[] args) {
    	getDbConnection();
//    	int i=insertintodb();
//    	if(i>0) {
//    		System.out.println(i +"rows effected");
  //  	}
   
    viewStudent();
    }
}
    

