package com.ssafy.servlet;

import java.io.IOException;
import java.util.List;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		
		
		switch (act) {
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			list(request, response);
			break;
		}
		
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 13_list.jsp 화면에 목록(PersonManager의 list)을 보여줘야함
		List<Person> list = PersonManager.getInstance().getList();
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("13_list.jsp");
		dispatcher.forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		Person p = new Person(name, age, gender, hobbies);
		
		PersonManager.getInstance().regist(p);
		
		//키/벨류의 형태로 속성을 삽입할 수 있다.
		request.setAttribute("person", p);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/12_result.jsp");
		disp.forward(request, response);
		
		
		//response.sendRedirect("12_result.jsp");
		
		
		
		
		
		
		
		
		
	}
	

}
