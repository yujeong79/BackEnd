package com.ssafy.servlet;

import java.io.IOException;
import java.security.Permissions;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 요청이 service로 들어올 것이기 때문에 어떤 요청인지 우선 판단하는 작업이 필요
		String act = request.getParameter("act");
		
		switch (act) {
		case "regist":
			doRegist(request, response);
			break;
	}
}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		Person p = new Person(name, age, gender, hobbies);
		
		PersonManager.getInstance().regist(p); // PersonManager가 가지고 있는 list에 p를 등록
	
		// key-value의 형태로 속성을 삽입할 수 있다.
		// 그니까 새로 등록된 사람 객체 p를 request에 담아서 result.jsp로 보낸다 => 페이지 이동
		request.setAttribute("person", p);
		
//		RequestDispatcher disp = request.getRequestDispatcher("12_result.jsp"); // => forward 방식
//		disp.forward(request, response);
		
		response.sendRedirect("12_result.jsp"); // 이렇게만 하면 다시 요청2를 보낼 때 그 request에는 Person p가 없어서 에러가 발생
	}
}
