<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Save Page</title>
<style type="text/css">
@CHARSET "ISO-8859-1";
body, #mainWrapper {
	height: 100%;
	padding:40px;
	background-color: #EFEFEF;	
}

body, #mainWrapper, .form-control{
	font-size:12px!important;
}

#mainWrapper {
	height: 100vh; 
	padding-left:10px;
	padding-right:10px;
	padding-bottom:10px;
}

.form-container {
  position:fiexd;
  width:70%;
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 20px;
  background-color: #E8E1E1;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.floatRight{
	float:right;
	margin-right: 18px;
}

.has-error{
	color:red;
}

.success{
  position:fiexd;
  width:70%;
  margin-left: 50px;
  margin-top:20px;
  padding: 20px;
  background-color: #E8E1E1;
  border: 1px solid #ddd;
  border-radius: 4px;
}
</style>
</head>
<body>
<div class="success">
		File  <strong>${fileName}</strong> uploaded successfully.
		<br/><br/>
	Go Back to	<a href="<c:url value='/welcome' />">Home Page</a>	
	</div>
</body>
</html>