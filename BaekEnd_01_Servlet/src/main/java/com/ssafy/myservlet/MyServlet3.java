/**
 * extends GenericServlet도 귀찮으면 extends HttpServlet을 사용한다.
 * 
 * Http는 통신 규약, Http 통신을 하는 사람들은 이런 Servlet을 사용하면 된다라고 이미 만들어져있다.
 */
package com.ssafy.myservlet;

import jakarta.servlet.http.HttpServlet;

public class MyServlet3 extends HttpServlet{ 
	// do어쩌고 메소드를 적어도 하나는 만들어야한다.
}
