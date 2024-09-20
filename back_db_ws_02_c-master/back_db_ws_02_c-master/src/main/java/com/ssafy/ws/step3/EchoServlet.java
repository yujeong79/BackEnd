package com.ssafy.ws.step3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Q. 클라이언트로부 전송된 파라미터 중 "type"에 해당하는 값을 저장해 봅시다. 
		String type = request.getParameter("type");
		
		
		/*
		 * Forward
		 * 
		 * 클라이언트의 요청에 대해 서버가 전달받아 이를 서버 내에 전달하는 방식을 말합니다.
		 * 클라이언트는 서버로 데이터만 전송할 뿐, 서버 내에 이루어지는 상황을 알 수 없습니다.
		 * 
		 * 서버 내부에서 데이터를 전달하기 때문에 request 객체를 그대로 전달하여 사용할 수 있습니다.
		 * 또한 URL의 변경이 일어나지 않습니다.
		 * 
		 * 
		 * 
		 * Redirect
		 * 
		 * 클라이언트의 요청에 대해 서버가 전달받은 후 Redirect가 발생하면 클라이언트에게 응답을 전송하며,
		 * 클라이언트는 서버에서 전달받은 요청에 대해 다시 서버로 요청을 전송합니다.
		 * Forward와 반대로 URL의 변경이 이루어지며, request 객체가 초기화됩니다.
		 * 
		 */


		// Q. type 파라미터 값이 "forward"인 경우를 처리하기 위한 조건문을 작성해 봅시다.
		if (type.equals("forward")) {
			
			request.setAttribute("message", type);
			
			// Q. Forward 요청을 처리하기 위해 서버 내에 존재하는 output.jsp로 전달해 봅시다.
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("output.jsp");
			
			
			// Q. requestDispatcher 객체를 이용하여 request와 response 객체를 forward 해봅시다.
			requestDispatcher.forward(request, response);
			
			
		// Q. type 파라미터 값이 "redirect"인 경우를 처리하기 위한 조건문을 작성해 봅시다.
		} else if (type.equals("redirect")) {
			
		     // Q. response 객체를 이용하여 "output.jsp"로 redirect 해봅시다.
		     response.sendRedirect("output.jsp");
		     
		}
	}
}
