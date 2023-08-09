<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="SuccessFail.css">
</head>
<body>
	<center>
	<div class="grp">
		<%
		session = request.getSession();
		out.println("\nYour Score is " + session.getAttribute("score"));
		%>
		</center>
		<br>
		<br>
		<br> <a href="StudentServices.html">Redirect to previous page</a>
	</div>
</body>
</html>