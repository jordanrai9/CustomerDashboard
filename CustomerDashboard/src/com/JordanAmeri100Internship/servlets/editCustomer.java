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
 * Servlet implementation class editCustomer
 */
@WebServlet("/editCustomer")
public class editCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cust_id = (String) request.getParameter("JordancustID");
		System.out.print("customer id is equal" + cust_id);
		int customer_id = Integer.parseInt(cust_id);
		Customer customer = new Customer();
		customer.setCustomerID(customer_id);
		
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection connection = DatabaseConnection.getSQLConnection();
			
			
			Customer cust = DatabaseUtil.getCustomer(customer, connection);
			DatabaseConnection.closeConnection(connection);
			if(cust.exists()){

				System.out.print(cust.getCustomerRevenue() + "from DB controller");
		          request.setAttribute("customer", cust);
		          System.out.print("from exists");
				RequestDispatcher dispatcher //
		         = this.getServletContext().getRequestDispatcher("/jsps/EditCustomer.jsp");

		         dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher //
		         = this.getServletContext().getRequestDispatcher("/getCustomerList");

		         dispatcher.forward(request, response);

				
			}
			
			
			  		   
			}
			catch (Exception e){
				System.out.println("From Post");
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
