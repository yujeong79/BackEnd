package com.ssafy.ws.step3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  HttpSession session = request.getSession(false); // 세션이 없으면 null을 반환
		  
		  if (session != null){
		  	// 세션을 무효화합니다.
		  	session.invalidate();
		  }
		  
		  response.sendRedirect("index.jsp"); // 로그아웃 후 메인 페이지로 리다이렉트
	  }
}
