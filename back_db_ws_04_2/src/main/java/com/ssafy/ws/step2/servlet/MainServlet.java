package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static int movieId = 0;
	private List<Movie> movieList = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		process(request, respond);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, respond);
	}

	private void process(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "regist":
			doRegist(request, respond);
			break;
<<<<<<< HEAD
		case "login":
			doLogin(request, respond);
			break;
		case "logout":
			doLogout(request, respond);
			break;
		case "list":
			doList(request, respond);
			break;
		}
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		request.setAttribute("movies", movieList);
		
		RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
		disp.forward(request, respond);
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse respond) {
		// TODO Auto-generated method stub
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse respond) {
		// TODO Auto-generated method stub
		
=======
		case "list":
			doList(request, respond);
			break;
		}
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		request.setAttribute("movies", movieList);
		
		RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
		disp.forward(request, respond);
>>>>>>> refs/remotes/origin/main
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
		int id = ++movieId;
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
		Movie movie = new Movie(id, title, director, genre, runningTime);
		
		request.setAttribute("movie", movie);
		
		movieList.add(movie);
		
		HttpSession session = request.getSession();
		session.setAttribute("movieCount", movieList.size());
		
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, respond);
	}
}
