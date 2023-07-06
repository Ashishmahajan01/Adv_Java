package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class LoginFile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname =request.getParameter("username");
		String pass = request.getParameter("password");
		if(uname.equalsIgnoreCase("Ashish") && pass.equals("iet")) {
			out.println("<h1>WELCOME GUYS!!!!!</h1>\n<h3>Ashish Website</h3>");
		}
		else {
			out.println("<script>alert(\"Invalid input\")</script>");
		}
	}
	
	

}
