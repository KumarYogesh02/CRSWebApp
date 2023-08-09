package com.digit.CrsWebApp.ProfessorController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CrsWebApp.model.ProfessorRequest;

@WebServlet("/NewProf")
public class NewProfessor extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int exp = Integer.parseInt(req.getParameter("exp"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        String cname = req.getParameter("cname");
        String uname = req.getParameter("uname");
        String desc = req.getParameter("desc");
		
		ProfessorRequest p = new ProfessorRequest();
		boolean b = p.addNewProf(name, age, exp, cid, cname, uname, desc);
				
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/Success.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/Fail.html");
        }
	}
}
