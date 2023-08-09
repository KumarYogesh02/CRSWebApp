package com.digit.CrsWebApp.StudentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.StudentRequest;

@WebServlet("/NewStudent")
public class NewStudent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        int cid = Integer.parseInt(req.getParameter("cid"));
        String cname = req.getParameter("cname");
        String uname = req.getParameter("uname");
        String desc = req.getParameter("desc");
		
		StudentRequest p = new StudentRequest();
		boolean b = p.addNewStud(name, age, email, cid, cname, uname, desc);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/Success.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/Fail.html");
        }
	}
}
