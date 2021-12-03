package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.User;

@SuppressWarnings("serial")
public class SignInServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		if(user.login()) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("Home.jsp");
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
