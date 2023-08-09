package com.digit.CrsWebApp.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.Users;



@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("auname");
		String pword = req.getParameter("apword");
		
		Users u = new Users();
        HttpSession session = req.getSession(true);
        
        boolean b = u.AdminLogin(uname, pword);
        if(b==true) {
        	resp.sendRedirect("/CRSWebApp/AdminServices.html");
        }
        else {
        	resp.sendRedirect("/CRSWebApp/LoginFail.html");
        }
	}
}
