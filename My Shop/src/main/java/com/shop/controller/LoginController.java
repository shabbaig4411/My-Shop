package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.shop.model_service.SignInImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile_email = request.getParameter("mobile_email");
		String password = request.getParameter("password");

		SignInImpl log = new SignInImpl();
		log.connectionDB();
		
		boolean result = log.verify(mobile_email, password);

		if (result) {
//			request.setAttribute("logged", "Logged successfully.");
//			rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
			HttpSession session = request.getSession(true);
			session.setAttribute("email_number", mobile_email);
			// we can invoke "/WEB-INF/view/home.jsp" directly and also like below example
			rd = request.getRequestDispatcher("homePageConnector");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Email/Mobile or Password is incorrect!...");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
