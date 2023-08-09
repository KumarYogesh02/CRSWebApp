package com.digit.CrsWebApp.AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Course;

@WebServlet("/viewC")
public class ViewCourses extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		Course c = new Course();
		ArrayList<Course> courses = c.Courses();
		HttpSession session = req.getSession();
		session.setAttribute("AllCourses", courses);
		
//		for (Course curc : courses) {
//			System.out.println(curc.getCid());
//			System.out.println(curc.getCname());
//			System.out.println(curc.getFees());
//			System.out.println(curc.getDur_months());
//			System.out.println("-----------");
//		}
		resp.sendRedirect("/CRSWebApp/viewCourses.jsp");
	}
}
