<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ClientServlet" method="post">
NAME : <input type="text" name="Username">
<input type="submit" value="Gooooo">
</form>

<br>
<form action="http://localhost:8016/com.googleDriveRestful/webapi/myresource/upload"
enctype="multipart/form-data" method="post">

<p>
Please specify a file<br>
<br>

<input type="file" name="file" size="45" >
 
</p>
<div>
<input type="submit" value="Upload">
</div>

</form>
</html>