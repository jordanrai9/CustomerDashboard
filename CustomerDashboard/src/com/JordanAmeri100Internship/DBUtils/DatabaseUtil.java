package com.JordanAmeri100Internship.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JordanAmeri100Internship.Beans.Customer;
import com.JordanAmeri100Internship.Beans.User;


public class DatabaseUtil {
	public static Customer getCustomer(Customer customer, Connection conn){
		 String sql = "Select Customer_ID, Customer_Name, "
		 		+ "Customer_Manager_ID, State, Region, Industry,"
		 		+ "Customer_Revenue, Customer_Classification, "
		 		+ "Basis_For_Customer_Classification "
		 		+ "from Customer "
		 		+ "Where Customer_ID = ?";
		 Customer cust = new Customer();
		 try{
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setInt(1, customer.getCustomerID());
	      System.out.print("customer id" + customer.getCustomerID());
	      System.out.println(pstm);
	      
	      
	      ResultSet rs = pstm.executeQuery();
	      
	      System.out.print("before while");
	      
	      while (rs.next()) {
	          System.out.print("here in dbutil found result");
	      	
	          String customerID = rs.getString("Customer_ID");
	          String custName = rs.getString("Customer_Name");
	          String custManagerID = rs.getString("Customer_Manager_ID");
	          String custState = rs.getString("State");
	          String custRegion = rs.getString("Region");
	          String custIndustry = rs.getString("Industry");
	          String custRevenue = rs.getString("Customer_Revenue");
	          String custClassification = rs.getString("Customer_Classification");
	          String custBasis = rs.getString("Basis_For_Customer_Classification");
	          
	          
	          
	          int cust_manager_id_int = Integer.parseInt(custManagerID);
	          int customer_id_int = Integer.parseInt(customerID);
	          int customer_revenue = Integer.parseInt(custRevenue);
	      	
	          cust.setCustomerID(customer_id_int);
	          cust.setCustomerName(custName);
	          cust.setCustomerManagerID(cust_manager_id_int);
	          cust.setState(custState);
	          cust.setRegion(custRegion);
	          cust.setIndustry(custIndustry);
	          cust.setCustomerRevenue(customer_revenue);
	          cust.setCustomerClassification(custClassification);
	          cust.setBasisForCustomerClassification(custBasis);
	          System.out.print("here in dbutil found result");
	          
	          System.out.print(cust.getCustomerRevenue() + "from DB Util");
	      }
	    
	    
	      }
		 catch(Exception e) {
			 System.out.println("From DB Utils");
			 System.out.println(e.getMessage());
			 e.printStackTrace(System.out);
		 }
	      return cust;
	  }
		

	  public static boolean updateCustomer(Connection conn, Customer customer) throws SQLException {
	      String sql = "Update Customer set Customer_Name=?, "
	      		+ "Customer_Manager_ID=?, State=?, Region=?, Industry=?, "
	      		+ "Customer_Revenue=?, Customer_Classification=?, "
	      		+ "Basis_For_Customer_Classification=? where Customer_ID =?";
	      
	      
	     
	      try {
	 	     
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, customer.getCustomerName());
	      pstm.setInt(2, customer.getCustomerManagerID());
	      pstm.setString(3, customer.getState());
	      pstm.setString(4, customer.getRegion());
	      pstm.setString(5, customer.getIndustry());
	      pstm.setInt(6, customer.getCustomerRevenue());
	      pstm.setString(7, customer.getCustomerClassification());
	      pstm.setString(8, customer.getBasisForCustomerClassification());
	      pstm.setInt(9, customer.getCustomerID());
	      
	      System.out.println(pstm);
	      
	      pstm.executeUpdate();
	      
	      
	      }

	      catch (Exception e ) {
	    	  System.out.println("From DB Utils");
	    	  System.out.println(e.getMessage());
				 e.printStackTrace(System.out);
				 return false;
	      }
	      return true;
	  }
	
	
	public static void insertCustomer(Connection conn, Customer customer) throws SQLException {
          String sql = "Insert into Customer(Customer_Name, Customer_Manager_ID, State, Region, Industry, Customer_Revenue, Customer_Classification, Basis_For_Customer_Classification) values (?,?,?,?,?,?,?,?)";
	     // String sql = "Insert into Customer (Customer_ID, Customer_Name) values (?,?)";
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      
	      pstm.setString(1, customer.getCustomerName());
	      pstm.setInt(2, customer.getCustomerManagerID());
	      pstm.setString(3, customer.getState());
	      pstm.setString(4, customer.getRegion());
	      pstm.setString(5, customer.getIndustry());
	      pstm.setString(7, customer.getCustomerClassification());
	      pstm.setInt(6, customer.getCustomerRevenue());
	      pstm.setString(8, customer.getBasisForCustomerClassification());	      
	      try {
	      pstm.executeUpdate();
	      }
	      catch (Exception e ) {
	    	  System.out.println("From DB Utils");
	      }
	      }
	 public static List<Customer> queryCustomer(Connection conn) throws SQLException {
	      String sql = "Select Customer_ID, Customer_Name, Customer_Manager_ID from Customer ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      
	      
	      ResultSet rs = pstm.executeQuery();
	      List<Customer> list = new ArrayList<Customer>();
	      while (rs.next()) {
	          String customerID = rs.getString("Customer_ID");
	          String customerName = rs.getString("Customer_Name");
	          String customerManagerID = rs.getString("Customer_Manager_ID");
	          Customer customer = new Customer();
	          
	          int cust_manager_id_int = Integer.parseInt(customerManagerID);
	          int customer_id_int = Integer.parseInt(customerID);
	      	
	          customer.setCustomerID(customer_id_int);
	          customer.setCustomerName(customerName);
	          customer.setCustomerManagerID(cust_manager_id_int);
	          list.add(customer);
	          System.out.println("getting records");
	      }
	      return list;
	  }
	 
	 public static User findUser(Connection conn, User user) throws SQLException {
         String sql = "Select User_Name, Password, User_Role From User_Account Where User_Name = ? and Password = ?";
	     // String sql = "Insert into Customer (Customer_ID, Customer_Name) values (?,?)";
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      System.out.println("From Query user name" + user.getName());
	      System.out.println("From Query password"+ user.getPassword());
	      
	      pstm.setString(1, user.getName());
	      pstm.setString(2, user.getPassword());
		  User user1 = new User();
		      
	      try {
	    	  ResultSet rs = pstm.executeQuery();
	          System.out.println("Executed Query");
	    	  
	    	  while (rs.next()) {
		          String userName = rs.getString("User_Name");
		          String userPassword = rs.getString("Password");
		          String userRole = rs.getString("User_Role");
		          System.out.println("From Result set" +  userName);
		          System.out.println("From Result set" +  userPassword);
		          System.out.println("From Result set" +  userRole);
		          user1 = new User();
		          user1.setName(userName);
		          user1.setPassword(userPassword);
		          user1.setRole(userRole);
		          System.out.println("getting user");
		          return user1;
		      }
	    	  
	      }
	      catch (Exception e ) {
	    	  System.out.println("From DB Utils");
	    	
	      }
          System.out.println("Returning Null");

	      return user1;
	     
	      }

}
