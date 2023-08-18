<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.digit.CrsWebApp.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image:
		url("https://images.unsplash.com/photo-1553095066-5014bc7b7f2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8d2FsbCUyMGJhY2tncm91bmR8ZW58MHx8MHx8fDA%3D&w=1000&q=80");
	background-size: cover;
	background-position: center;
}
body::before {
			content: "";
			background-image: inherit;
			background-size: cover;
			background-repeat: no-repeat;
			filter: blur(2px);
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			z-index: -1;
		}
.container {
	max-width: 900px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}
input[type="submit"]{
align-self: center;
	display: flex;
	align-items: center;
	display: inline-block;
	
  text-decoration: none;
  padding: 10px 20px; 
  border-radius: 4px;
  background-color: #007BFF;
  color: #fff;
  margin-bottom: 10px;
  justify-content: center;
    text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 15px;
	text-align: center;
	border: 1px solid #ccc;
}

th {
	background-color: #3366cc;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	display: block;
	margin-top: 20px;
	text-align: center;
	color: #3366cc;
	text-decoration: none;
	font-weight: bold;
	transition: color 0.3s;
}

a:hover {
	color: #005580;
}

tr.green {
	background-color: #c8e6c9;
}

tr.red {
	background-color: #ffcdd2;
}
</style>
</head>
<body>
<%
session = request.getSession();
Student s = (Student) session.getAttribute("markscard");
	%>
	<center>
	<div class="container">
	
	<h1 align="center">Marks Card:</h1>
		<br>
		<table border="1">
			<tr>
		
			<th>Student Name</th>
			<th>Student Username</th>
			<th>Student Age</th>
			<th>Student Email</th>
			<th>Course id</th>
			<th>Course name</th>
			<th>Score</th>
			</tr>
		
			<tr>
		
			<td><%=s.getSname()%></td>
			<td><%=s.getUser_name()%></td>
			<td><%=s.getAge()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getCid()%></td>
			<td><%=s.getCourse()%></td>
			<td><%=s.getScore()%></td>
			</tr>
			

		</table>
		</center>
		</div>
</body>
</html>