package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Course;
import com.digit.CrsWebApp.model.Professor;

@WebServlet("/removeProf")
public class RemoveProfessor extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("pid"));
		
		Professor p = new Professor();
		boolean b = p.remProf(pid);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/AdminSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/AdminFail.html");
        }
	}
}
