package com.shop.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCustomerController")
public class addCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public addCustomerController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("Don't Refresh the page.....Please wait.");
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addDistributor.jsp");
	rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String name = request.getParameter("name");
		
		
		
		
	}

}
