package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.Professor;

@WebServlet("/addprof")
public class AddProfessor extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
		
		Professor p = new Professor();
		boolean b = p.addProf(uname);
		boolean b1 = p.remProfReq(uname);
				
        if(b==true && b1==true) {
        	resp.sendRedirect("/CRSWebApp/AdminSuccess.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/AdminFail.html");
        }
	}
}
