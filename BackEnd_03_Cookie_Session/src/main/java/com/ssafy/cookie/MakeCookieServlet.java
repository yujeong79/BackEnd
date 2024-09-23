package com.ssafy.cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		System.out.println(key);
		
		// 쿠키를 생성해보자. 
		// 쿠키는 하나의 문자열 데이터 조각이다.
		Cookie cookie = new Cookie(key, value);
		
		// 유효시간 결정 : 초단위
		cookie.setMaxAge(60); // 1분, 1시간:3600, 1일:3600*24
		
		// 쿠키를 삭제하고 싶다.
//		cookie.setMaxAge(0); // 쿠키를 삭제하는 방법, 유효기간을 줄여버리기
		
		// 응답 통로에 쿠키를 담아서 사용자에게 돌려주기.
		resp.addCookie(cookie);
		
		// 쿠키를 응답에 담아서 클라이언트에게 다시 보내고
		// 클라이언트가 다시 02_CookieResult.jsp에 재요청을 보내도록 한다.
		resp.sendRedirect(req.getContextPath()+"/02_CookieResult.jsp");
	}
	
	// 쿠키를 삭제하는 예시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		for(Cookie c : req.getCookies()) {
			if(c.getName().equals(name)) {
				c.setMaxAge(0);
			}
		}
	}
	
}
