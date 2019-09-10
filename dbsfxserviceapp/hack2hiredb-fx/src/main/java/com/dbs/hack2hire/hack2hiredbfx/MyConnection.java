package com.dbs.hack2hire.hack2hiredbfx;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection implements Serializable,Cloneable{

	 private static Connection obj;
	 private MyConnection() {} 
	  
	    public static Connection getInstance() throws SQLException, ClassNotFoundException 
	    { 
	        if (obj==null) 
	        	Class.forName("com.mysql.jdbc.Driver");
	           obj= DriverManager.getConnection("jdbc:mysql://database-1.cvmaaipomipt.ap-south-1.rds.amazonaws.com:3306/fx_data", "admin", "Welcome123") ;
	        return obj; 
	    } 
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	    	throw new CloneNotSupportedException();
	    }
}
