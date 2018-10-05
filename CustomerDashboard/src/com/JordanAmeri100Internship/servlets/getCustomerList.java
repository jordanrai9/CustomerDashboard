package com.JordanAmeri100Internship.servlets;

import java.io.IOException;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JordanAmeri100Internship.Conn.DatabaseConnection;
import com.JordanAmeri100Internship.DBUtils.DatabaseUtil;
import com.JordanAmeri100Internship.Beans.Customer;


/**
 * Servlet implementation class getCustomerList
 */
@WebServlet("/getCustomerList")
public class getCustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCustomerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String errorString = null;
		 List<Customer> list = null;
		// TODO Auto-generated method stub
		
		 try{
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				Connection connection = DatabaseConnection.getSQLConnection();
				list = DatabaseUtil.queryCustomer(connection);
   				DatabaseConnection.closeConnection(connection); 
				for(int i = 0; i < list.size(); i++){
					System.out.println(list.get(i).getCustomerID());
				}
				}
				catch (Exception e){
		            e.printStackTrace();
		            errorString = e.getMessage();
				}			
		 
		        request.setAttribute("errorString", errorString);
        request.setAttribute("customerList", list);
         
     
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/jsps/customerList.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
