package com.digit.CrsWebApp.AdminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CrsWebApp.model.ProfessorRequest;

@WebServlet("/viewPR")
public class ViewProfessorRequests extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession curSession = req.getSession();
		ProfessorRequest pr = new ProfessorRequest();
		ArrayList<ProfessorRequest> prs = pr.PRs();
		HttpSession session = req.getSession();
		session.setAttribute("AllPRs", prs);
		resp.sendRedirect("/CRSWebApp/ViewProfessorRequests.jsp");
	}
}
