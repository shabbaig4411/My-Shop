package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.shop.model_service.Services_Impl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile_email = (String)request.getParameter("mobile_email");
		String password =(String) request.getParameter("password");

		RequestDispatcher rd = null;
		Services_Impl service = new Services_Impl();
		service.connectionDB();		
		boolean result = service.verify(mobile_email, password);
		
		if (result) {
			
//			int userId = service.getuserId(mobile_email);
//			
//			HttpSession session = request.getSession(true);
//			session.setAttribute("userId", userId);
			// we can invoke "/WEB-INF/view/home.jsp" directly and also like below example
			request.setAttribute("mobile_email", mobile_email);
			rd = request.getRequestDispatcher("homePageConnector");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Email/Mobile or Password is incorrect!...");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
