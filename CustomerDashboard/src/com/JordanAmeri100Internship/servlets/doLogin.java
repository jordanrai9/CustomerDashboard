 package com.JordanAmeri100Internship.servlets;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JordanAmeri100Internship.Beans.User;
import com.JordanAmeri100Internship.Conn.DatabaseConnection;
import com.JordanAmeri100Internship.DBUtils.DatabaseUtil;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
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
		// TODO Auto-generated method stub
		// Get Input from Login Screen
		
		String username = (String) request.getParameter("UserName");
	    String password = (String) request.getParameter("Password");
	
		User user = new User();
        String errorString = null;
        Connection connection = null;
        
        user.setName(username);
	    user.setPassword(password);
	    
	    // Check errors in Input 
	    if (username == null || password == null
                || username.length() == 0 || password.length() == 0) {
           errorString = "Required username and password!";
           
           request.setAttribute("errorString", errorString);
           request.setAttribute("test", user);
           
           // Forward to /WEB-INF/views/login.jsp
	         RequestDispatcher dispatcher //
	         = this.getServletContext().getRequestDispatcher("/jsps/Login.jsp");

	         dispatcher.forward(request, response);
  		   
	    }
           else {
        	   // Verify User in Database
        	   try{
        		String driver = "com.mysql.jdbc.Driver";
   				Class.forName(driver);
   				connection = DatabaseConnection.getSQLConnection();
   				
   				User userVerified = DatabaseUtil.findUser(connection,user);
   				DatabaseConnection.closeConnection(connection); 
     	         request.setAttribute("errorString", errorString);
     	         request.setAttribute("user", user);

     	    
     	        // If the user/password combination does not exist
   			       if( userVerified.getName() == null){
        			   errorString = "User Name or Password Invalid";
        			   System.out.println("none");
        			   User user2 = new User();
          	           user2.setName(username);
          	           user2.setPassword(password);
          	         System.out.println("test1");
          	     
          	         // Store information in request attribute, before forward.
          	         request.setAttribute("errorString", errorString);
          	         request.setAttribute("user", user);
          	       System.out.println("test");

          	    
          	         // Forward to /jsps/login.jsp
          	     RequestDispatcher dispatcher1 //
			  		= this.getServletContext().getRequestDispatcher("/jsps/Login.jsp");

			  	dispatcher1.forward(request, response);

        		   }
        		   else{
     			      
        			  // if user password exists  
        			  HttpSession session = request.getSession();
         	          session.setAttribute("LoginUser", userVerified);
         	          request.setAttribute("user", userVerified);

        			  if (userVerified.getRole().equals("CXO")) {
        				  // Redirect to CXO page.
        				  		RequestDispatcher dispatcher2 //
        				  		= this.getServletContext().getRequestDispatcher("/jsps/WelcomeCXO.jsp");
          	 
        				  	dispatcher2.forward(request, response);
        			   } else if (userVerified.getRole().equals("Admin")) {
             	        
        				  	// Redirect to Admin page.
        				  	RequestDispatcher dispatcher3 //
        				  	= this.getServletContext().getRequestDispatcher("/jsps/WelcomeAdmin.jsp");
          	 
        				  	dispatcher3.forward(request, response);
        			   }
        	
        		   }
          	   }
        	   catch(Exception e){
        		   System.out.println("From Post");
        	   }
         	   
           }	
	}
} 
	


	
	
