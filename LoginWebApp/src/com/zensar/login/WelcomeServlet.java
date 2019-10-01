package com.zensar.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(5);
		
		PrintWriter out= response.getWriter();
		String username=request.getParameter("username");
		
		String logouturlenc=response.encodeURL("logout");
		out.println("<p><a href= '"+logouturlenc+"'>Logout</a> </p>");
		
		out.println("<p> Dear" + username+ "welcome to online shopping Home</p>");
		out.println("<p> Your Session timeout period is: "+session.getMaxInactiveInterval() +" seconds </p>");
		
		out.println("<p><a href= 'searchInfo'>Search</a> </p>");
		out.println("<p><a href= 'amazonInfo'>Amazon</a> </p>");
		String producturlenc=response.encodeURL("product");
		out.println("<p>To Select Products click here <a href= '"+ producturlenc +"'>click here</a> </p>");
		
		

		session.setAttribute("uname", username);
		System.out.println("session id in welcomeservlet:" + session.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
