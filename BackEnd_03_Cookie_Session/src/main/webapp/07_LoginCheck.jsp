<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	// 화면을 보여줄건 아니니까 HTML 코드는 필요없어!
 	
 	String id = request.getParameter("id");
 	String pw = request.getParameter("password");
 	
 	// id와 pw를 이용하여 실제 유저인지 확인해보자.
 	// 이건 사실 DB를 배운 뒤에야 제대로 할 수 있다.
 	// 혹은 Manager를 통해서 유저 목록을 직접 관리하면서 확인할 수 있다.
 	// 근데 지금 우린 둘 다 없으니까.. 조건문으로 확인해보자..ㅠ
 	if(id.equals("ssafy") && pw.equals("1234")) {
 		// 로그인 성공했으면 세션에 저장하자!
 		// JSP에서는 session이라는 기본객체가 이미 들어있어!
 		// 그리고 또 어디에 쿠키에 저장한거싱ㅁ?
 		session.setAttribute("userid", id);
 		
 		// 만약 servlet이었다면 session을 가져오는 방법은?
 		// 쿠키 목록을 전부 가져와서 JSESSIONID 이름을 가진 쿠키가 있는지 확인하고
 		// 해당 쿠키를 이용하여 세션ID를 확보하고 가지고 온다.
 		// 그런데 이건 이미 sessionId를 가지고 있을 때 가져오는 방법 아닌가? 새로 생성하는건 어떻게 하는거지?
 		HttpSession mySession = request.getSession();
 		
 		// Main.jsp 페이지 이동을 할건데 두 가지 방식 중 어떤 방법을 선택해야할까?
 		// 1. 포워딩
 		//request.getRequestDispatcher("08_Main.jsp").forward(request, response);
 		
 		// 2. 리다이렉트, 여기선 리다이렉트가 맞다.
 		// 애초에 세션은 서버에 저장되기 때문에 다시 request하는 과정에서 정보가 넘겨져야할 필요가 없고
 		// 포워딩을 하게 되면 08_Main.jsp에 LoginForm에서 요청된 pw 정보까지 넘어가게 되므로
 		// 리다이렉트 방식으로 이동하게 되면 08_Main_jsp에는 세션에 저장된 id 정보만 넘어가게 되므로 리다이렉트가 맞다.
 		response.sendRedirect("08_Main.jsp");
 		
 		
 	} else {
 		// 로그인 실패했으면 다시 원래 페이지로 보내버리자.
 		response.sendRedirect("07_LoginForm.jsp");
 	}
 	
 %>