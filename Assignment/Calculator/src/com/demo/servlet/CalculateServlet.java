package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CalculateServlet extends HttpServlet {
	
	private  int factorial(int num) {
		int f=1;
		for(int i=1;i<=num;i++) {
			f=f*i;
		}
		return f;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String btn =  request.getParameter("btn");
		switch(btn) {
		case "add":
			int num2 = Integer.parseInt(request.getParameter("num2"));
			out.println("<h3>Addition:"+(num1+num2)+"</h3>");
			break;
		case "fact":
			int ans = factorial(num1);
			out.println("<h3>Factorial: "+ ans + "</h3>");
			break;
		}
		
	}

}
