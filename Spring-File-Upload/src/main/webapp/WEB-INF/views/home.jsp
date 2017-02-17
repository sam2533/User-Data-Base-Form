<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Welcome Page</title>
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
		<h1>Welcome to FileUploader Example</h1>
		
		Click on below links to see File Upload section<br/><br/>
		You can choose to upload more than One document....
		
		<a href="<c:url value='/singleUpload' />">Single File Upload</a>  OR  <a href="<c:url value='/multiFileUpload' />">Multi File Upload</a>
	</div>
</body>
</html>
