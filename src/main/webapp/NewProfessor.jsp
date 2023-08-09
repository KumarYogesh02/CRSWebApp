<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.digit.CrsWebApp.model.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session = request.getSession();
	Course c1 = new Course();
	ArrayList<Course> c = c1.Courses();
	%>
	<center>
		<h1 align="center">All Courses</h1>
		<br>
		<table border="1">
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Fee</th>
				<th>Course Duration</th>
			</tr>
			<%
			for (Course curc : c) {
			%>
			<tr>
				<td><%=curc.getCid()%></td>
				<td><%=curc.getCname()%></td>
				<td><%=curc.getFees()%></td>
				<td><%=curc.getDur_months()%></td>
			</tr>
			<%
			}
			%>
		</table>
		</center><br><br><br>
		<center><h2>New Professor Request</h2></center><br><br>
	<form action="NewProf" method="post">
		<center>
		<label>Name        :   </label><input type="text"     name="name"><br><br>
		<label>Age         :   </label><input type="text"     name="age"><br><br>
		<label>Experience  :   </label><input type="text"     name="exp"><br><br>
		<label>Course ID   :   </label><input type="text"     name="cid"><br><br>
		<label>Course Name :   </label><input type="text"     name="cname"><br><br>
		<label>User Name   :   </label><input type="text"     name="uname"><br><br>
		<label>Description :   </label><input type="text"     name="desc"><br><br>
		<input type="submit">
		</center>
	</form>
</body>
</html>