package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int v = Integer.parseInt(request.getParameter("v"));
		String op = request.getParameter("op");
		
		int result = 0;
		if(op.equals("=")) {
//			int x = (Integer)session.getAttribute("value");
			int y = v;
			int x = 0;
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
				
				if(c.getName().equals("op")) {
					operator = c.getValue();
				}
				
			}
			
//			String operator = (String)session.getAttribute("op");
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			out.println(result);
			
		}else {
//			session.setAttribute("value", v);
//			session.setAttribute("op", btn);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
			
		}
	}

}
