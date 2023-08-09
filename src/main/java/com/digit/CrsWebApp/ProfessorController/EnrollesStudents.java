package com.digit.CrsWebApp.ProfessorController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Student;
@WebServlet("/enrolledstud")
public class EnrollesStudents extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		Student s = new Student();
		String u = (String) curSession.getAttribute("puname");
		ArrayList<Student> ss = s.enrollesstud(u);
		HttpSession session = req.getSession();
		session.setAttribute("enrolleds", ss);
		resp.sendRedirect("/CRSWebApp/EnrolledStudents.jsp");
	}
}
