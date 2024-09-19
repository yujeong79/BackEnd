/**
 * 매번 implements Servlet해서 메소드를 정의하는 것이 귀찮을 때
 * 이미 다 구현되어 있는 GenericServlet extends해서 service 추상메소드만 정의하면 된다.
 */

package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// 요청과 응답만 구현하면 됨
		
	}

}
