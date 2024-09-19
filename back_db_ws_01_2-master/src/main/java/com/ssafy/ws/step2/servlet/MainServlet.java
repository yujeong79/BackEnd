package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static int movieId = 0;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * get 방식의 요청에 대해 응답하는 메소드
	 * front controller pattern(하나의 servlet에서 모든 요청에 대해 구분지어서 처리하는 방법)을 적용하기 위해
	 * 내부적으로 process를 호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	/**
	 * request에서 전달 받은 내용을 추출해서 Movie 객체를 생성한 후 response로 출력한다.
	 * @param request
	 * @param response
	 */
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "regist":
			movieId++;
			doRegist(request, response);
			break;
		}
		
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
		Movie movie = new Movie(movieId, title, director, genre, runningTime);
		
		StringBuilder output = new StringBuilder();
		
		output.append("<html><body>").append("<h1>영화 정보</h1>").append(movie.toString()).append("</body></html>");
	
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
	}
}
