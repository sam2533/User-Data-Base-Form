<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiple File Upload Page</title>
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

	<div class="form-container">
		<h1>Multiple File Upload Section </h1>
		<form:form method="POST" modelAttribute="multiFileBucket" enctype="multipart/form-data" class="form-horizontal">
		
			<c:forEach var="v" varStatus="vs" items="${multiFileBucket.files}">
				<form:input type="file" path="files[${vs.index}].file" id="files[${vs.index}].file" class="form-control input-sm"/>
				<div class="has-error">
					<form:errors path="files[${vs.index}].file" class="help-inline"/>
				</div>
			</c:forEach>
			<br/>
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Upload" class="btn btn-primary btn-sm">
				</div>
			</div>
		</form:form>
		
		<br/>
		Go Back to <a href="<c:url value='/welcome' />">Home Page</a>
	</div>
</body>
</html>