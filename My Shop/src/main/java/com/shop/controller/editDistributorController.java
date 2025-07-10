package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import com.shop.model_service.Services_Impl;

@WebServlet("/editDistributorController")
public class editDistributorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editDistributorController() {
		super();
	}

	RequestDispatcher rd = null;
	String userId = null;
	String distributorId = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			userId = (String) session.getAttribute("userId");
			if (userId == null) {
				response.sendRedirect("index.jsp");
			} else {
				distributorId = (String) request.getParameter("distributorId");

				Services_Impl service = new Services_Impl();
				service.connectionDB();
				ResultSet result = (ResultSet) service.getDistributor(userId, distributorId);

				request.setAttribute("result", result);
				rd = request.getRequestDispatcher("/WEB-INF/view/editDistributor.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession(false);
			userId = (String) session.getAttribute("userId");
			if (userId == null) {
				response.sendRedirect("index.jsp");
			} else {
				String name = (String) request.getParameter("name");
				String mobile = (String) request.getParameter("mobile");
				String email = (String) request.getParameter("email");

				Services_Impl service = new Services_Impl();
				service.connectionDB();
				ResultSet distributor = (ResultSet) service.updateDistributor(userId, distributorId, name, mobile,
						email);

				request.setAttribute("distributor", distributor);
				rd = request.getRequestDispatcher("/WEB-INF/view/distributors.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
