package com.ssafy.ws.step3.servlet;

import java.io.IOException;

import com.ssafy.ws.step3.dao.BookDao;
import com.ssafy.ws.step3.dao.BookDaoImpl;
import com.ssafy.ws.step3.dao.UserDao;
import com.ssafy.ws.step3.dao.UserDaoImpl;
import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	private BookDao bookDao = BookDaoImpl.getInstance();
	private UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		switch(action) {
		case "registUser":
			doRegistUser(request, response);
			break;
		case "regist":
			doRegist(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "updateForm":
			goToUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "remove":
			doRemove(request, response);
			break;
		}
		
	}

	private void doRegistUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String rec_id = request.getParameter("rec_id");
		
		String msg = "회원가입 실패!";
		
		User user = new User(id, name, password, rec_id);
		if(userDao.insert(user)) {
			msg = "회원가입 성공!";
		}
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("id");
		
		bookDao.remove(isbn);
		
		response.sendRedirect("main?action=list");
	}
	
	private void goToUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("id");
		request.setAttribute("book", bookDao.selectOne(isbn));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, desc, img);
		
		bookDao.update(book);
		
		response.sendRedirect("main?action=detail&id="+isbn);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("id");
		request.setAttribute("book", bookDao.selectOne(isbn));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detail.jsp");
		dispatcher.forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books", bookDao.selectAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, desc, img);
		bookDao.insert(book);
		
		response.sendRedirect("main?action=list");
	}
	
}
