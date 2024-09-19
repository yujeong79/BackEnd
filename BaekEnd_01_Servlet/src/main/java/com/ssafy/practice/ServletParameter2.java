package com.ssafy.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.tribes.util.Arrays;

@WebServlet("/ServletParameter2")
public class ServletParameter2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form_03_input.html 데이터들을 받아서 출력해보자..
		
		String text = req.getParameter("text");
		System.out.println(text);
		
		int number = Integer.valueOf(req.getParameter("number"));
		System.out.println(number);
		
		String campus = req.getParameter("campus");
		System.out.println(campus);
		
//		String fruit = req.getParameter("fruit"); // 1개만 리턴
//		System.out.println(fruit);
		String[] fruits = req.getParameterValues("fruit"); // 여러개 리턴
		System.out.println(Arrays.toString(fruits));
		
		String pl = req.getParameter("programming-language");
		System.out.println(pl);
		
		String content = req.getParameter("content");
		System.out.println(content);
		
		String action = req.getParameter("action");
		System.out.println(action);
		
		String fruitStr = "";
		for(String string : fruits) {
			fruitStr += string + " ";
		}
		
		PrintWriter writer = resp.getWriter();
		
		writer.write("""
		<html>
		<meta charset = "UTF-8">
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>게시물 등록 완료</h1>
		    text : """ + text + """ 
		    		<br/>
    		text : """ + number + """ 
    				<br/>
			text : """ + fruitStr + """ 
		    		<br/>
		  </body>
		</html>
		""");
	}


}
