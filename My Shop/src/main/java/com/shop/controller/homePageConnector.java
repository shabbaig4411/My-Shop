package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.shop.model_service.Services_Impl;

@WebServlet("/homePageConnector")
public class homePageConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public homePageConnector() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile_email= (String)request.getAttribute("mobile_email");
		Services_Impl service = new Services_Impl();
		service.connectionDB();
		int userId = service.getuserId(mobile_email);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
		rd.forward(request, response);
	}

}
