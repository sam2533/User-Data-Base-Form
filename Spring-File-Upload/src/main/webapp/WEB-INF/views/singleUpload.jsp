<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single File Upload Page</title>
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
		<h1>Single File Upload Page </h1>
		<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="file">UPLOAD A FILE</label>
					<br>
					<div class="col-md-7">
						<form:input type="file" path="file" id="file" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="file" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
		<br>
			<div class="row">
					<input type="submit" value="Upload" class="btn btn-primary btn-sm">
			</div>
		</form:form>
		<br>
		<a href="<c:url value='/welcome' />">Home Page</a>
	</div>
</body>
</html>