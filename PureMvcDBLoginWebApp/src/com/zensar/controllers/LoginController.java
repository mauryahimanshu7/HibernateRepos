package com.zensar.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;

import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();
		//Represents entire web Application created only one and available to all the servelets.
		String driverClassName = context.getInitParameter("jdbcDriver");
		String dbUrl = context.getInitParameter("jdbcUrl");
		String dbUserName= context.getInitParameter("dbUser");
		String dbPassword = context.getInitParameter("dbPassword");
		
		
		//load jdbc driver class
		
		try
		{
		Class.forName(driverClassName);
		context.log("JDBC DRIVER IS LOADED SUCCESFULLY");
		Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		context.log("Mysql database connection is established successfully");
		UserDao userDao = new UserDaoImpl();
		((UserDaoImpl) userDao).setConnection(con);
		UserService userService=new UserServiceImpl();
		((UserServiceImpl) userService).setUserdao(userDao);
		//set userservice to a servlet
		setUserService(userService);
		context.log("UserService is set in LoginServelet");
		
	}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
			User clientUser =new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			//invoking business logic
			
			try
			{
			if(userService.validateUser(clientUser)) 
			{
				//out.println("<p> Dear "+username+" "+" Welcome to Zensar</p>");
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
			}
			
			else
			{
				out.println("<p> Sorry!!! Invalid Credentials</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
	}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
