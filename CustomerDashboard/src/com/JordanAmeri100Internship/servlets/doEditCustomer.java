package com.JordanAmeri100Internship.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JordanAmeri100Internship.Beans.Customer;
import com.JordanAmeri100Internship.Conn.DatabaseConnection;
import com.JordanAmeri100Internship.DBUtils.DatabaseUtil;

/**
 * Servlet implementation class doEditCustomer
 */
@WebServlet("/doEditCustomer")
public class doEditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doEditCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the input from Customer Screen
		String cust_id = (String) request.getParameter("JordanCustID");
		String cust_name = (String) request.getParameter("JordanCustName");
	    String cust_manager_id = (String) request.getParameter("JordanCustManagerID");
	    String state = (String) request.getParameter("JordanState");
	    String region = (String) request.getParameter("JordanRegion");
	    String industry = (String) request.getParameter("JordanIndustry");
	    String cust_rev = (String) request.getParameter("JordanCustRevenue");
	    String cust_class = (String) request.getParameter("JordanCustClass");
	    String basis = (String) request.getParameter("JordanBasis");
	    
	    int customer_id = Integer.parseInt(cust_id);
		
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
			  customer.setCustomerID(customer_id);
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
		         = this.getServletContext().getRequestDispatcher("/jsps/EditCustomer.jsp");

		         dispatcher.forward(request, response);
	  		   
			  
		  }
		
		   // Parse the strings to integer
	       int cust_manager_id_int = Integer.parseInt(cust_manager_id);
	       
	       int cust_revenue_int = Integer.parseInt(cust_rev);

	       Customer customer = new Customer(customer_id, cust_name, cust_manager_id_int, state, region
	    		       ,industry,cust_revenue_int,
	    		      cust_class, basis );
	       customer.showCustomer();
	       
			try{
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				Connection connection = DatabaseConnection.getSQLConnection();
				Boolean result = DatabaseUtil.updateCustomer(connection, customer);
   				DatabaseConnection.closeConnection(connection); 
				if(result){
			    
   				String customerAdded = "Record updated";
				request.setAttribute("customerAdded", customerAdded);
				request.setAttribute("customer",customer);
				}
				
				RequestDispatcher dispatcher //
		         = this.getServletContext().getRequestDispatcher("/getCustomerList");

		         dispatcher.forward(request, response);
	  		   
				}
				catch (Exception e){
					System.out.println("From Post");
				}
				
				
		

		
	
	}

}
