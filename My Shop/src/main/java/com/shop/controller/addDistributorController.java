package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.shop.model_service.Services_Impl;

@WebServlet("/addDistributorController")
public class addDistributorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addDistributorController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("Don't Refresh the page.....Please wait.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addDistributor.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String userId = null;
		String distributorId = null;
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(false);
			userId = (String) session.getAttribute("userId");
			if (userId == null) {
				response.sendRedirect("index.jsp");
			} else {
				Services_Impl service = new Services_Impl();
				service.connectionDB();
				distributorId = service.getDid(userId);
				request.setAttribute("distributor", distributorId);

				ResultSet distributor = (ResultSet) service.addDistributors(userId, distributorId, name, mobile, email);
				request.setAttribute("distributor", distributor);
				rd = request.getRequestDispatcher("/WEB-INF/view/distributors.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "Login Again...");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}
}
