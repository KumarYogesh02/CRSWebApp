package com.digit.CrsWebApp.StudentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Professor;
import com.digit.CrsWebApp.model.Student;

@WebServlet("/studLogin")
public class StudentLogin extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("suname");
		String pword = req.getParameter("spword");
		
		Student s = new Student();
        HttpSession session = req.getSession(true);
        
        boolean b = s.StudentLogin(uname, pword);
        if(b==true) {
        	session.setAttribute("uname",uname);
        	resp.sendRedirect("/CRSWebApp/StudentServices.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/LoginFail.html");
        }
	}
}
