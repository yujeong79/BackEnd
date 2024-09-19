/**
 * Servlet도 결국 class이므로 직접 만들어보자
 */

package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet1 implements Servlet{ // implements 했다는 것은 Servlet은 인터페이스라는 의미

	@Override
	public void destroy() {
		// 서블릿이 소멸할 때
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// 서블릿 설정 객체 반환
		return null;
	}

	@Override
	public String getServletInfo() {
		// 서블릿 정보를 문자열의 형태로 반환
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// 서블릿을 초기화할 때
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 요청과 응답 처리
		
	}

}
