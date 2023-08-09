package com.digit.CrsWebApp.StudentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Student;

@WebServlet("/scorecard")
public class MarksCard extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String u = (String) session.getAttribute("uname");
		Student s = new Student();
		boolean b = s.scorecard(u);

		if (b == true) {
			session.setAttribute("markscard", s);
			resp.sendRedirect("/CRSWebApp/MarksCard.jsp");
		} else {
			resp.sendRedirect("/CRSWebApp/StudentFail.html");
		}
	}
}
