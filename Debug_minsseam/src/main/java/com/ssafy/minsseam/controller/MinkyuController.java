package com.ssafy.minsseam.controller;

import java.io.IOException;

import com.ssafy.minsseam.model.dto.Minkyu;
import com.ssafy.minsseam.model.service.MinkyuService;
import com.ssafy.minsseam.model.service.MinkyuServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
과목평가 8회차 Debug 연습 (BackEnd: Servlet & JSP, Database : MySQL)
제공파일 : 프로젝트 압축파일
오류수정하기

워크스페이스 변경
인코딩설정
서버등록
import => 오류 수정

[약속]
Context-root : /mk
Servlet 경로 : /minsseam
frontController parameter : action
DB명 : minsseam_test
	(DB서버주소, 포트번호, 계정, 비번 은 우리 사용하는 값 그대로임)
DB table 명 : minkyu

DB table 컬럼 구조
타입		컬럼명	제약사항
숫자		user_id	기본키, 자동증가값
문자열 최대 100자	name 	널안됨
문자열 최대 100자	email 	널안됨 유일값 UNIQUE

DTO class 명 : Minkyu

[수정금지] 되어있는 곳은 수정하지 마세요 오류 없는 부분임

 */

@WebServlet("/minsseam")
public class MinkyuController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final String prefix = "/WEB-INF/minkyu/";
	private MinkyuService service = MinkyuServiceImpl.getInstance();

	// [이 service() 메서드는 수정금지] 오류없음
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "registform":
			doRegistForm(request, response);
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
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath());
			break;
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Minkyu minkyu = new Minkyu();

		minkyu.setUserid(Integer.parseInt(request.getParameter("id")));
		minkyu.setName(request.getParameter("name"));
		minkyu.setEmail(request.getParameter("email"));
		
		response.sendRedirect("minsseam?action=detail");
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("minkyu", service.getMinkyu(id));
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "updateform.jsp");
		dispatcher.forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("list");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("minkyu", service.getMinkyu(id));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "detail.jsp");
		dispatcher.forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controller -> service -> dao -> DB select * from minkyu
		// selectAll 해서 조회해온 List를 request에 담아서 list.jsp로 보내기
		
		request.setAttribute("list", service.getMinkyuList());
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "list.jsp");
		dispatcher.forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Minkyu minkyu = new Minkyu(name, email);
		request.setAttribute("minkyu", minkyu);
		
		service.registMinkyu(minkyu);
		
		// 등록 완료 후 목록으로 이동해야하는데
		// 목록으로 갈 땐 리스트 데이터를 가지고 가야하니까 서블릿 action=list sendRedirect를 해주어야한다.
		response.sendRedirect("minsseam?action=list");
	}

	private void doRegistForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + "registform.jsp");
		
		dispatcher.forward(request, response);
	}
}
