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


@WebServlet("/deleteDistributorController")
public class deleteDistributorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteDistributorController() {
        super();
        
    }

    RequestDispatcher rd = null;
	String userId = null;
	String distributorId =null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		userId = (String) session.getAttribute("userId");
		distributorId = (String)request.getParameter("distributorId");
		
		Services_Impl service = new Services_Impl();
		service.connectionDB();
		service.deleteDistributor(userId,distributorId);

		rd = request.getRequestDispatcher("distributorsController");
		rd.forward(request, response);
		service.getDistributors(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
