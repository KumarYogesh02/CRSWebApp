package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Student;

@WebServlet("/removeStud")
public class RemoveStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
		
		Student s = new Student();
		boolean b = s.remStud(sid);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/AdminSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/AdminFail.html");
        }
	}
}
