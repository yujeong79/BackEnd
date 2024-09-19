package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet { // HelloServlet은 HttpServlet을 extends 한 클래스이다.
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 요청과 응답을 받아서
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>Hello! SSAFY!</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("<h1>Hello! Servlet!</h1>");
		writer.write("<p>Hello! SSAFY</p>");
		writer.write("</body>");
		writer.write("</html>");
		
		//Java 15 버전에 나온 Block String, 원래는 위와 같은 방법으로 한 줄 씩 썼어야 했는데 Java 15 버전부터 이렇게 한 번에 쓸 수 있게 되었다.
//		writer.write("""
//		<html>
//		  <head><title>Hello! SSAFY!</title></head>
//		  <body>
//		    <h1>Hello! Servlet!</h1>
//		  </body>
//		</html>
//		""");

	}
}


