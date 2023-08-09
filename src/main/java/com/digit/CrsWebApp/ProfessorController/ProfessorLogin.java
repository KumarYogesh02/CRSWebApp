package com.digit.CrsWebApp.ProfessorController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Professor;
import com.digit.CrsWebApp.model.Users;

@WebServlet("/profLogin")
public class ProfessorLogin extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("puname");
		String pword = req.getParameter("ppword");
		
		Professor p = new Professor();
        HttpSession session = req.getSession(true);
        
        boolean b = p.ProfessorLogin(uname, pword);
        if(b==true) {
        	session.setAttribute("puname",uname);
        	resp.sendRedirect("/CRSWebApp/ProfessorServices.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/LoginFail.html");
        }
	}
}
