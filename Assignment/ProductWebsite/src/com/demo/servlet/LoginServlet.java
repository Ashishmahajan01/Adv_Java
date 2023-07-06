package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginService ls = new LoginServiceImpl();
		MyUser u=ls.validateUser(uname,pass);
		if(u==null) {
			out.println("<h3>Invalid User</h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request,response);
		}
		else {
			System.out.println("in Else part");
			HttpSession session=request.getSession();
			if(session.isNew()) {
				System.out.println("session is new");
				session.setAttribute("user", u);
			}
			RequestDispatcher rd1= request.getRequestDispatcher("product");
			rd1.forward(request,response);
		}
		
	}

}
