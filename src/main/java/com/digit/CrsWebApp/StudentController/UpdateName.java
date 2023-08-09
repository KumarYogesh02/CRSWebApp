package com.digit.CrsWebApp.StudentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Student;


@WebServlet("/updateName")
public class UpdateName extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("nn");
        HttpSession session = req.getSession();
        String u = (String) session.getAttribute("uname");
        
        Student s = new Student();
        boolean b = s.changeName(n,u);
        
        if(b==true) {
            resp.sendRedirect("/CRSWebApp/StudentSuccess.html");
        }
        else {
            resp.sendRedirect("/CRSWebApp/StudentFail.html");
        }
	}
}
