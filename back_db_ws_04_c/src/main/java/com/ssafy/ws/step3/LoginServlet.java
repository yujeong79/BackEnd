package com.ssafy.ws.step3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8"); // JDK 10 이전 버전에서는 필요합니다.
		
		// 요청 파라미터 userId와 password를 얻어냅니다.
	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");

	    // 여기에서 사용자 인증을 수행합니다.
	    // 이 예제에서는 단순화를 위해 id는 "ssafy" 그리고 password는 "1234"로 일치하면 성공으로 가정합니다.
		if (!userId.equals("ssafy") || !password.equals("1234")) {
			// 로그인 실패 시에는 다시 메인페이지로 포워딩으로 방식으로 이동하며, 이때 실패 사유에 대한 메시지를 같이 전달합니다.
			request.setAttribute("userId", userId);
			request.setAttribute("password", password);
			request.setAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
		    
			return;
		}
	    
	    // 사용자 인증이 성공하면 세션을 생성합니다.
	    HttpSession session = request.getSession();
	    session.setAttribute("loginUser", userId);

	    response.sendRedirect("index.jsp"); // 로그인 후 메인 페이지로 리다이렉트
	  }
	}
