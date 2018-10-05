package com.JordanAmeri100Internship.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection getSQLConnection()
			throws ClassNotFoundException, SQLException {
		    Connection conn = null;
		     try {
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
			            "Pentree40");
			 System.out.println("Got Connection");
			    
		     }
			 catch (Exception e){
				 System.out.println("Error From Connection");
			 }
			 return conn;
		}

public static boolean closeConnection (Connection connection) {
	    
		boolean Success = false;
		System.out.println("before close connection");
		try {	
		if (connection != null && !connection.isClosed()) {
		       try {
		    	   System.out.println("close connection");
		          connection.close();
		          Success = true;
		       }
		    
		       catch (SQLException e) {
		    	  Success = false;
		        // Don't throw from here or you'll lose any return/exception from above
		          System.out.println("Failed to close connection" + e);
		       }
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
        return Success;
    }

	}
