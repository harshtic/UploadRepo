package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.User;

public class SignUpServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		User user = new User(name,email,password,contact);
		if(user.saveUser()) {
			response.sendRedirect("signin.jsp");
		}
		else {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		
	}

}
