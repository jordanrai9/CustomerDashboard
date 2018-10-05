<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="doEditCustomer">
       <table border="0">
          <tr>
             <td>Customer ID</td>
             <td><input type="text" name="JordanCustID" value= "${customer.getCustomerID()}" readonly/></td>
          </tr>
          
          <tr>
             <td>Customer Name</td>
             <td><input type="text" name="JordanCustName" value= "${customer.getCustomerName()}"/></td>
          </tr>
          <tr>
             <td>Customer Manager ID</td>
             <td><input type="text" name="JordanCustManagerID" value= "${customer.getCustomerManagerID()}" /></td>
          </tr>
          <tr>
             <td>State</td>
             <td><input type="text" name="JordanState" value= "${customer.getState()}"/></td>
          </tr>
          <tr>
             <td>Region</td>
             <td><input type="text" name="JordanRegion" value= "${customer.getRegion()}"/></td>
          </tr>
          <tr>
             <td>Industry</td>
             <td><input type="text" name="JordanIndustry" value= "${customer.getIndustry()}"/></td>
          </tr>
          <tr>
             <td>Customer Revenue</td>
             <td><input type="text" name="JordanCustRevenue" value= "${customer.getCustomerRevenue()}"/></td>
          </tr>
          <tr>
             <td>Customer Classification</td>
             <td><input type="text" name="JordanCustClass" value= "${customer.getCustomerClassification()}"/></td>
          </tr>
          <tr>
             <td>Basis for Customer Classification</td>
             <td><input type="text" name="JordanBasis" value= "${customer.getBasisForCustomerClassification()}"/></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 Cancel
             </td>
             </tr>
          </table>
          </form>
           <div style="color:red">${errorString} </div> <br>
           <div style="color:red">${errorStringRevenue} </div> <br>
           <div style="color:red">${errorStringManagerId} </div> <br>
           <div style="color:blue">${customerAdded} </div>


</body>
</html>