<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.digit.CrsWebApp.model.Professor"%>
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
		url("/MVCBankApp/images/BankApp1.png");
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
	ArrayList<Professor> p = (ArrayList<Professor>) session.getAttribute("AllPs");
	%>
	<center>
	<div class="container">
	<h1 align="center">All Professors</h1>
		<br>
		<table border="1">
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>User Name</th>
			<th>Password</th>
			</tr>
			<%
			for (Professor curp : p) {
			%>
			<tr>
			<td><%=curp.getPid()%></td>
			<td><%=curp.getPname()%></td>
			<td><%=curp.getAge()%></td>
			<td><%=curp.getExp()%></td>
			<td><%=curp.getCid()%></td>
			<td><%=curp.getCourse()%></td>
			<td><%=curp.getUser_name()%></td>
			<td><%=curp.getPassword()%></td>
			</tr>
			<%
			}
			%>

		</table>
		</center>
		</div>
</body>
</html>