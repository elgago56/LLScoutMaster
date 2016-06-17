package com.scm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		try {
			request.login(username, password);
		} catch (ServletException e) {
			request.getRequestDispatcher("/index.jsp?login_failed=true").forward(request, response);
		}

		request.getRequestDispatcher("/").forward(request, response);
	}

}
