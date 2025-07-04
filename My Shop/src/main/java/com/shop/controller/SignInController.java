package com.shop.controller;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import com.shop.model_service.SignInImpl;

@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("password1");
		
		response.setContentType("text/html");
		RequestDispatcher rd = null;

		if (password1.equals(password2) || password1 == password2) {
			SignInImpl creat = new SignInImpl();
			creat.connectionDB();
			boolean result = creat.newUser(name, mobile, email, password1);
			if (result) {

				request.setAttribute("result", "Account Created Successfully. Go to <a href='index.jsp'>Login</a>");
				rd = request.getRequestDispatcher("SignIn.jsp");
				rd.forward(request, response);
			}

		} else {
			request.setAttribute("msg", "password cannot be differnt!...");
			rd = request.getRequestDispatcher("SignIn.jsp");
			rd.forward(request, response);
		}
	}
}
