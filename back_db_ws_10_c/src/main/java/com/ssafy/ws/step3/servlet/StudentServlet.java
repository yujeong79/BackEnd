package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.ws.step3.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/main")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Q. 학생의 정보를 데이터베이스의 접근 로직을 처리하는 객체를 생성해 봅시다.
    private static StudentDao studentDao = StudentDaoImpl.getInstance();

    // GET, POST 방식의 요청을 받아서 front controller pattern을 적용하기 위해 process 메서드를 호출한다.
    // front controller pattern : 클라이언트의 요청을 한 곳으로 집중시켜서 요청에 대한 처리를 담당하는 컨트롤러를 만들어서
    // 관리하는 패턴
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
        // 생성(CREATE) : 학생 등록
        case "regist":
            doRegist(request, response);
            break;
        // 조회(READ) : 학생 목록 조회
        case "list":
            doList(request, response);
            break;
        // 조회(READ) : 학생 상세 조회
        case "detail":
            doDetail(request, response);
            break;
        // 삭제(DELETE) : 학생 삭제
        case "delete":
            doRemove(request, response);
            break;
        // 수정(UPDATE): 학생 수정
        case "update":
            doUpdate(request, response);
            break;
        }
    }

    // 생성(CREATE) : 학생을 등록합니다.
    private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int campus = Integer.parseInt(request.getParameter("campus"));
        int curriculum = Integer.parseInt(request.getParameter("curriculum"));
        String birth_date = request.getParameter("birth_date");
        String major = request.getParameter("major");
        int in_ssafy = Integer.parseInt(request.getParameter("in_ssafy"));
        
        try {
            // Q. 학생의 정보를 데이터베이스에 추가하는 메소드를 호출해 봅시다.
            studentDao.insert(id, name, gender, campus, curriculum, birth_date, major, in_ssafy);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Q. list 페이지로 이동하는 코드를 작성해 봅시다.
        // hint : list.jsp는 포워드 방식으로 학생들의 데이터를 전달 받아야만 합니다.
        // 기존 프론트 컨트롤러 패턴을 적용한 process 메소드를 이용하여 list 페이지로 이동합니다.
        response.sendRedirect("main?action=list");
    }

    // READ : 학생 목록을 조회합니다.
    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setAttribute("students", studentDao.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // forward 방식으로 list.jsp로 이동합니다.
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    // READ : 학생 상세 정보를 조회합니다.
    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String id = request.getParameter("id");

        try {
            // Q. 학생의 단일 정보를 조회하는 메소드를 호출해 봅시다.
            request.setAttribute("student", studentDao.selectOne(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // forward 방식으로 detail.jsp로 이동합니다.
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    // UPDATE : 학생을 수정합니다.
    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int campus = Integer.parseInt(request.getParameter("campus"));
        int curriculum = Integer.parseInt(request.getParameter("curriculum"));
        String birth_date = request.getParameter("birth_date");
        String major = request.getParameter("major");
        int in_ssafy = Integer.parseInt(request.getParameter("in_ssafy"));

        try {
            studentDao.update(id, name, gender, campus, curriculum, birth_date, major, in_ssafy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Q. 해당하는 학생의 상세 페이지로 이동하는 코드를 작성해 봅시다.
        // hint : list.jsp는 포워드 방식으로 학생들의 데이터를 전달 받아야만 합니다.
        // 기존 프론트 컨트롤러 패턴을 적용한 process 메소드를 이용하여 list 페이지로 이동합니다.
        response.sendRedirect("main?action=detail&id=" + id);	
    }

    // DELETE : 학생을 삭제합니다.
    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        try {
            // Q. 해당하는 id의 학생의 정보를 삭제하는 메소드를 호출해 봅시다.
            studentDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Q. list 페이지로 이동하는 코드를 작성해 봅시다. (*위의 Q과 동일한 코드입니다.)
        response.sendRedirect("main?action=list");
    }

}
