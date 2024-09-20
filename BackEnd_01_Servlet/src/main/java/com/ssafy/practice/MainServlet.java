package com.ssafy.practice;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.dto.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form_04_gugu 해보기
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form_05_signup 해보기
		doProcess(req, resp);
	}
	
	// 한 번에 처리하고 싶으면
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String action = req.getParameter("action");
		switch(action) {
		case "regist":
			// 등록하는 작업 (메소드로 빼서 사용 가능)
			// 인간에 대한 정보가 요청 통로 안에 몽땅 들어있다.
			regist(req, resp);
			break;
		case "gugu" :
			// 구구단을 하는 작업 (메소드로 빼서 사용 가능)
//			int dan = Integer.valueOf(req.getParameter("dan"));
//			System.out.println(dan);
//			
//			String gugudan = "";
//			for(int i = 1; i <= 9; i++) {
//				gugudan += dan+"*"+i+"="+(i*dan) + "\n";
//			}
//			
//			PrintWriter writer = resp.getWriter();
//			
//			writer.write("""
//			<html>
//			<meta charset = "UTF-8">
//			  <head><title>Hello! SSAFY!</title></head>
//			  <body>
//			    <h1>구구단</h1>
//			    gugudan : """ + gugudan + """ 
//			  </body>
//			</html>
//			""");
//			break;
			gugu(req, resp);
			break;
		}

	}

	private void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 인간에 대한 정보가 요청 통로 안에 몽땅 들어있다.
		String name = req.getParameter("name");
		int age = Integer.valueOf(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String[] hobbys = req.getParameterValues("hobby");
		Person person = new Person(name, age, gender, hobbys);
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>사람가입 성공</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write(person.toString());
		writer.write("</body>");
		writer.write("</html>");
	}

	private void gugu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int dan = Integer.valueOf(req.getParameter("dan"));
		System.out.println(dan + "단");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>Hello! SSAFY!</title>");
		writer.write("</head>");
		writer.write("<body>");
		for(int i = 1; i <= 9; i++) {
			writer.write(dan + " * " + i + " = " + dan*i + "<br/>"); 
		}
		writer.write("</body>");
		writer.write("</html>");
	}
}
