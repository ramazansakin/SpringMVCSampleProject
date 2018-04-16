package com.obss.ramazansakin.springpro.configuration;

import java.sql.Connection;
import java.sql.DriverManager;


public class HibernateConf {
    
    public Connection getConn(){
       
    	try{
			String url = "jdbc:mysql://localhost:3306/USER";
			String user = "root";
			String password = "350358458";
	
			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establish connection to MySQL
			Connection conn = DriverManager.getConnection(url, user, password);
	        
            return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
       return null;
    }
        
}
