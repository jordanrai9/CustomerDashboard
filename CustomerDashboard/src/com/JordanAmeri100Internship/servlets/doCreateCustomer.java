package com.JordanAmeri100Internship.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JordanAmeri100Internship.Beans.Customer;
import com.JordanAmeri100Internship.Conn.DatabaseConnection;
import com.JordanAmeri100Internship.DBUtils.DatabaseUtil;


@WebServlet("/doCreateCustomer")
public class doCreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public doCreateCustomer() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("I always am default");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the input from Customer Screen
		String cust_name = (String) request.getParameter("JordanCustName");
	    String cust_manager_id = (String) request.getParameter("JordanCustManagerID");
	    String state = (String) request.getParameter("JordanState");
	    String region = (String) request.getParameter("JordanRegion");
	    String industry = (String) request.getParameter("JordanIndustry");
	    String cust_rev = (String) request.getParameter("JordanCustRevenue");
	    String cust_class = (String) request.getParameter("JordanCustClass");
	    String basis = (String) request.getParameter("JordanBasis");
	    
		System.out.println(cust_name);
		System.out.println(cust_manager_id);
		System.out.println(state);
		System.out.println(region);
		System.out.println(industry);
		System.out.println(cust_rev);
		System.out.println(cust_class);
		System.out.println(basis);
		
		String errorString = null;
		boolean hasError = false;
		   
		// input fields cannot be blank
		if (cust_name == "" || cust_manager_id == "" || state == "" || 
			region == "" || industry == "" || cust_rev == "" || 
			cust_class == "" || basis == "") {
			
			errorString = "Fields cannot be blank";
			hasError = true;
		}
			
		
		   // integer fields should be number
	
		  String errorStringRevenue = null;
		  String errorStringManagerId = null;
		  
		
		  String regex = "\\d+";
		  if (cust_rev.matches(regex) == false ) {
			  errorStringRevenue = "Revenue must be a number";
			  hasError = true;
			  
		  }
		  
		  if (cust_manager_id.matches(regex) == false){
			  errorStringManagerId = "Customer Manager ID must be a number";
			  hasError = true;
		  }
		  
		  if (hasError){
			  Customer customer = new Customer();
			  customer.setCustomerName(cust_name);
			  customer.setState(state);
			  customer.setRegion(region);
			  customer.setIndustry(industry);
			  customer.setBasisForCustomerClassification(basis);
			  customer.setCustomerClassification(cust_class);
			  
			  request.setAttribute("errorString", errorString);
	          request.setAttribute("errorStringRevenue", errorStringRevenue);
	          request.setAttribute("errorStringManagerId", errorStringManagerId);
	          request.setAttribute("customer", customer);
	           
	           // Forward to /WEB-INF/views/login.jsp
		         RequestDispatcher dispatcher //
		         = this.getServletContext().getRequestDispatcher("/jsps/Customer2.jsp");

		         dispatcher.forward(request, response);
	  		   
			  
		  }
		
		   // Parse the strings to integer
	       int cust_manager_id_int = Integer.parseInt(cust_manager_id);
	       System.out.println(cust_manager_id_int);
	       
	       int cust_revenue_int = Integer.parseInt(cust_rev);
	       System.out.println(cust_revenue_int);
	       
	      
	   		
	       
	       Customer customer = new Customer(0, cust_name, cust_manager_id_int, state, region
	    		       ,industry,cust_revenue_int,
	    		      cust_class, basis );
			try{
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				Connection connection = DatabaseConnection.getSQLConnection();
				DatabaseUtil.insertCustomer(connection, customer);
   				DatabaseConnection.closeConnection(connection); 
				String customerAdded = "One record added";
				request.setAttribute("customerAdded", customerAdded);
				
				
				RequestDispatcher dispatcher //
		         = this.getServletContext().getRequestDispatcher("/jsps/Customer2.jsp");

		         dispatcher.forward(request, response);
	  		   
				}
				catch (Exception e){
					System.out.println("From Post");
				}
				
				
		

		
	}

}
