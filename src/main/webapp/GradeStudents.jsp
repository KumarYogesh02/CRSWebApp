<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.digit.CrsWebApp.model.Student"%>
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
		url("https://img.freepik.com/free-vector/abstract-blue-geometric-shapes-background_1035-17545.jpg?w=2000");
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
	
    Student s = new Student();
    HttpSession curSession = request.getSession();
    String u = (String) curSession.getAttribute("puname");
    ArrayList<Student> s1 = s.enrollesstud(u);
	
	%>
	<center>
	<div class="container">
	<h1 align="center">Enrolled Students</h1>
		<br>
		<table border="1">
			<tr>
			<th>ID</th>
			<th>Name</th>
			</tr>
			<%
			for (Student curs : s1) {
			%>
			<tr>
			<td><%=curs.getSid()%></td>
			<td><%=curs.getSname()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<br>
		<br>
		<br>
	</div>
	
	<div class="grp">
		<h2>Grade Student</h2>
	
	<form action="grade" method="post">
		<center>
			<label>Student ID : </label><input type="text" name="sid"><br><br><br>
			<label>Score      : </label><input type="text" name="score"><br><br><br>
			<br> <input type="submit"><br>
			<br>
		</center>
	</form>
	</div>
</body>
</html>