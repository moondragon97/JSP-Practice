package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 String _temp = request.getParameter("cnt");
		 int _input = 10;
		 if(_temp != null && !_temp.equals("")) {
			 _input = Integer.parseInt(request.getParameter("cnt"));
		 }
		 for(int i=0; i<_input; i++)
			 out.println("안녕하세요~~~ dddd<br >");
	} 
}