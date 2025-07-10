package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

import com.shop.model_service.Services_Impl;

@WebServlet("/distributorsController")
public class distributorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public distributorsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = null;
		String distributorId = null;

		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(false);
			userId = (String) session.getAttribute("userId");
			
			// Use like below ( if & else)  statement in each controller to auto refresh the page when user get back the page.//
			if(userId==null) {
				response.sendRedirect("index.jsp");
			}else {
			Services_Impl service = new Services_Impl();
			service.connectionDB();
			distributorId = service.getDid(userId);

			ResultSet distributor = (ResultSet) service.getDistributors(userId);
			request.setAttribute("distributor", distributor);
			rd = request.getRequestDispatcher("/WEB-INF/view/distributors.jsp");
			rd.forward(request, response);}
		} catch (Exception e) {
			request.setAttribute("message", "Login Again...");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UserId is present in session //
		String userId = null;

		HttpSession session = request.getSession(false);
		userId = (String) session.getAttribute("userId");

	}

}
