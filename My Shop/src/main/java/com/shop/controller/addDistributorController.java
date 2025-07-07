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
		int userId = 0;
		int distributorId=0;
		RequestDispatcher rd = null;
		try {
			HttpSession session = request.getSession(false);
			userId = (int) session.getAttribute("userId");
			
			Services_Impl service = new Services_Impl();
			service.connectionDB();
			distributorId = service.getDid(userId);
			request.setAttribute("distributor", distributorId);
			
			
			
			ResultSet distributor = (ResultSet)service.addDistributors(userId,distributorId, name, mobile, email);
			request.setAttribute("distributor", distributor);
			rd = request.getRequestDispatcher("/WEB-INF/view/distributors.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("error", "Login Again...");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

		
		
		// All Tables are Created @SignIn Execution// 
		// service.distributorsTable(); // Services_Impl (line-70)
		
		
				// 1 set distributor has both did, name. Extract at receiver(.jsp) page.//
				 

				// 2 Extract, then set.//
//				int did = (int) distributor.getInt("distributorId");
//				request.setAttribute("did", did);
//				request.setAttribute("dName", name);

				// 3 This will add one more method to implement(Implemented at->Services_Impl
				// (Line 100)).//
				// int did=service.getDistributor(userId,name,mobile,email);
				// ResultSet distributor = (ResultSet) service.getDistributor(userId,did);

				
				
//			}else{
//				request.setAttribute("error",
//						"Distributor is Already Exists, Or try to create with different credentials...");
//				rd = request.getRequestDispatcher("/WEB-INF/view/addDistributor.jsp");
//				rd.forward(request, response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
