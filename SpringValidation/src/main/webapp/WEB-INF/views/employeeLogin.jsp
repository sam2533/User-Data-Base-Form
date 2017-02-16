<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Employee Page</title>
<style type="text/css">
.errors
{
	color:#008080;
	font-style:oblique;
	font-weight:bold;
}
</style>
</head>
<body>
<h2>Welcome to login page</h2>
<h2>This page is only for Employee login</h2>
<springForm:form method="POST" commandName="employee" action="save">
	<table>
		<tr>
			<td>User Name</td>
			<td><springForm:input path="userName"/></td>
			<td><springForm:errors path="userName" cssClass="errors"/></td>
		</tr>
		<tr>
			<td>Password </td>
			<td><springForm:password path="password"/></td>
			<td><springForm:errors path="password" cssClass="errors"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><springForm:input path="email"/></td>
			<td><springForm:errors path="email" cssClass="errors"/></td>
		</tr>
		<tr>
			<td>Birth Day</td>
			<td><springForm:input path="date" placeholder="MM/dd/yyyy"/></td>
			<td><springForm:errors path="date" cssClass="errors"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Login"></td>
		</tr>
	</table>
</springForm:form>
</body>
</html>