package com.digit.CrsWebApp.AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Student;

@WebServlet("/viewS")
public class ViewStudents extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		Student s = new Student();
		ArrayList<Student> ss = s.Ss();
		HttpSession session = req.getSession();
		session.setAttribute("AllSs", ss);
		resp.sendRedirect("/CRSWebApp/ViewStudents.jsp");
	}
}
