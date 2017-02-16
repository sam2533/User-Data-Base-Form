<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Login Page</title>
</head>
<body>
	<h2>You Have Succesfully login this page, Mr. ${employee.userName}</h2>

The information you have given are below:
<strong> User Name: 	${employee.userName}</strong><br>
<strong> Password:  	${employee.password}</strong><br>
<strong> Email:     	${employee.email}</strong><br>
<strong> Date of Birth:	 <fmt:formatDate value="${employee.date}" type="date"/></strong><br>
</body>
</html>