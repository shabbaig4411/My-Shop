package com.shop.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customersController")
public class customersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public customersController() {
		super();

	}

	String userId = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			userId = (String) session.getAttribute("userId");

			if (userId == null) {
				response.sendRedirect("index.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addCustomer.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String e_mobile = (String) session.getAttribute("email_number");
		request.setAttribute("email", e_mobile);

	}

}
