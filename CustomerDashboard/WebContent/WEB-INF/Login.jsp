<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

<form method="post" action="doLogin">
        <div style="color:red"> ${errorString} </div>
<div id=outPopUp>

        
       <table border="0">
          
          <tr>
             <td>User Name</td>
             <td><input type="text" name="UserName" value="${user.getName()}"/></td>
          </tr>
          <tr>
             <td>Password</td>
             <td><input type="text" name="Password" value="${test.getPassword()}"/></td>
          </tr>
          
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 
             </td>
             </tr>
          </table>
         
         </div>
          
          </form>

</body>
</html>