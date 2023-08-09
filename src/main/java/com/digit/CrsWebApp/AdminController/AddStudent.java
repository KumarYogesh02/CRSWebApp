package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Student;

@WebServlet("/addstud")
public class AddStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
		
		Student s = new Student();
		boolean b = s.addStud(uname);
		boolean b1 = s.remStudReq(uname);
				
        if(b==true && b1==true) {
        	resp.sendRedirect("/CRSWebApp/AdminSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/AdminFail.html");
        }
	}
}
