<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style>
h2{
	text-align:center;
}
#maindiv{
	
}

</style>
<meta charset="ISO-8859-1">
<title>automobile service company</title>
</head>
<body>
<h2>ABC Automobile Service Company</h2>
<div class="col-md-3">
<div id="maindiv" class="form-group">
<c:set var="checkRequest" value="Login" scope="session"/>
<form action="loginServlet" method="post">
	<label for="empName">User Name</label><br />
	<input type="text" name="empName" placeholder="enter user name" id="empName" class="form-control"/><br /><br />
	
	<label for="password">Password</label><br />
	<input type="password" name="password"  placeholder="enter password" id="password" class="form-control"/><br /><br />
	
	
	<input type="submit"  value="login" class="btn btn-primary"/><br /><br />
	
	<a href="registration.jsp">New user?Sign up</a>
	
</form>
</div>
</body>
</html>