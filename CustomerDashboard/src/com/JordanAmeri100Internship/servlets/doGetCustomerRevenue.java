package com.JordanAmeri100Internship.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JordanAmeri100Internship.Beans.Customer;
import com.JordanAmeri100Internship.Conn.DatabaseConnection;
import com.JordanAmeri100Internship.DBUtils.DatabaseUtil;

/**
 * Servlet implementation class doGetCustomerRevenue
 */
@WebServlet("/doGetCustomerRevenue")
public class doGetCustomerRevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doGetCustomerRevenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		cust.setCustomerID(7);
		
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection connection = DatabaseConnection.getSQLConnection();
			Boolean result = DatabaseUtil.getRevenue(connection, cust);
			
			
				DatabaseConnection.closeConnection(connection); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
