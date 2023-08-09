package com.digit.CrsWebApp.AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.StudentRequest;

@WebServlet("/viewSR")
public class ViewStudentRequests extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		StudentRequest sr = new StudentRequest();
		ArrayList<StudentRequest> srs = sr.SRs();
		HttpSession session = req.getSession();
		session.setAttribute("AllSRs", srs);

		resp.sendRedirect("/CRSWebApp/ViewStudentRequests.jsp");
	}
}
