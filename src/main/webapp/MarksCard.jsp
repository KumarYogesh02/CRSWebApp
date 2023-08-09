<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.CrsWebApp.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
@charset "ISO-8859-1";
*{

    margin: 0;

    padding: 0;

    box-sizing: border-box;

   
}

body{
		
      background-image: url('');
      
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-color: rgb(197, 194, 188);
    
	}
body{
	font-family: Arial, sans-serif;

    background-color:rgb(231, 230, 226);
justify-content: center;
    align-items: center;
    
}


label {
    font-weight: bold;
    
    display: block;
    margin-bottom: 5px;
}

form {
  background-color: rgb(255, 255, 255);
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.cont-login{
	 display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    filter: blur('2px');
}

h3 {
    text-align: center;
    font-size: 24px;
    margin-bottom: 10px;
}

.container{

    
    max-width: 700px;

    width: 105%;

    background:rgb(255, 255, 255);

    padding: 25px;

    border-radius: 10px;

    

}

input[type="text"] {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid rgb(0, 0, 0);
    border-radius: 5px;
    margin-bottom: 10px;
}

input {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid rgb(64, 0, 64);
  border-radius: 4px;
}

input[type="submit"] {
  background-color: rgb(128, 128, 255);
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s;
}
p{
align-items:center;
}



  </style>
</head>
<body>
<center>
		<div class="cont-login">
	<%
	session = request.getSession();
	Student s = (Student) session.getAttribute("markscard");
	%>
	<h3 class="app-title">Marks Card:</h3>
	<p>
		ID:
		<%=s.getSid()%></p>
	<p>
		Name:
		<%=s.getSname()%></p>
	<p>
		User Name:
		<%=s.getUser_name()%></p>
	<p>
		Age:
		<%=s.getAge()%></p>
	<p>
		Email:
		<%=s.getEmail()%></p>
	<p>
		Course ID:
		<%=s.getCid()%></p>
	<p>
		Course:
		<%=s.getCourse()%></p>
	<p>
		Score:
		<%=s.getScore()%></p>
</div>
</center>
</body>
</html>