package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logOutController")
public class logOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public logOutController() {
		super();
	}

	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
		
			// session.setMaxInactiveInterval(60);
			// Don't use this statement here, B'coz, this page directly "LOGOUT automatically", & back to login page. //
			// Any Servlet which has session access & this statement then if ( user Inactive for upto 60 seconds "LOGOUT automatically", & back to login page.) //
			
			if (session != null) {
			    session.invalidate();
			
			// In this statement session variable will become empty, Without userId we haven't given access our App, back to Login page. //
			
			// 1. Calling Back Login Page, with an message. Using implicit request Object. //
//			request.setAttribute("message", "Logged Out Successfully... Login Again.");	
//			rd = request.getRequestDispatcher("index.jsp");
			// rd.forward(request, response);
			
			// 2. Calling Back Login Page.  Using implicit response Object.//
			// response.sendRedirect("index.jsp");// 2.1. only calling, no message here.//
			// This is perfect — just don’t use RequestDispatcher here, since session is already gone. //
			response.sendRedirect("index.jsp?message=Logged+Out+Successfully.");// 2.2. Calling with message. //

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
