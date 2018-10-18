<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="checkRequest" value="register" scope="session"/>
<form action="loginServlet" method="post">
	<label for="empName">user name</label>
	<input type="text" name="Name" placeholder="enter user name" id="Name"/><br /><br />
	
	<label for="password">Password</label>
	<input type="passWord" name="passWord"  placeholder="enter password" id="passWord"/><br /><br />
	
	<label for="empId">Employee ID</label>
	<input type="text" name="empId"  placeholder="enter id" id="empId"/><br /><br />
	
	<input type="submit"  value="register"/><br /><br />
	
	
	
</form>
</body>
</html>