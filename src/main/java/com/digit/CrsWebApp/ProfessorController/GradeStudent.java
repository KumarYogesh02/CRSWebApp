package com.digit.CrsWebApp.ProfessorController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Student;

@WebServlet("/grade")
public class GradeStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
		int score = Integer.parseInt(req.getParameter("score"));
		
		Student s = new Student();
		boolean b = s.grade(sid, score);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/ProfessorSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/ProfessorFail.html");
        }
	}
}
