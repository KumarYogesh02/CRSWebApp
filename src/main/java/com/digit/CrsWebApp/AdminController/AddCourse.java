package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Course;

@WebServlet("/addcourse")
public class AddCourse extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cname = req.getParameter("cname");
		int cfee = Integer.parseInt(req.getParameter("cfee"));
		int cdur = Integer.parseInt(req.getParameter("cdur"));
		
		Course c = new Course();
		boolean b = c.addCourse(cname, cfee, cdur);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/AdminSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/AdminFail.html");
        }
	}
}
