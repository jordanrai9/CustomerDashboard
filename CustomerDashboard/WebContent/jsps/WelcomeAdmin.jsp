<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome ${user.getName()} <br>
Identify by ${user.getPassword()} <br>
Role ${user.getRole()} <br>

<a href="http://localhost:8080/CustomerDashboard/getCustomerList">Customer Management</a>

</body>
</html>