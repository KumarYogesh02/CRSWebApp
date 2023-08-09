package com.digit.CrsWebApp.ProfessorController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Professor;

@WebServlet("/updatePName")
public class UpdateName extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("nn");
        HttpSession session = req.getSession();
        String u = (String) session.getAttribute("puname");
        
        Professor p = new Professor();
        boolean b = p.changeName(n,u);
        
        if(b==true) {
            resp.sendRedirect("/CRSWebApp/ProfessorSuccess.html");
        }
        else {
            resp.sendRedirect("/CRSWebApp/ProfessorFail.html");
        }
	}
}
