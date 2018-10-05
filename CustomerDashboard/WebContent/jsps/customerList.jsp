<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Customer ID</th>
          <th>Customer Name</th>
          <th>Customer Manager ID</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${customerList}" var="customer" >
          <tr>
             <td>${customer.getCustomerID()}</td>
             <td>${customer.getCustomerName()}</td>
             <td>${customer.getCustomerManagerID()}</td>
             <td>
           
	           <a href=http://localhost:8080/CustomerDashboard/editCustomer?JordancustID=${customer.getCustomerID()}> Edit </a>
             </td>
             <td>
               Delete
             </td>
          </tr> 
       </c:forEach>
       
       
     
    </table>
 
    <a href="http://localhost:8080/CustomerDashboard/createCustomer">Create Customer</a>
 
</body>
</html>