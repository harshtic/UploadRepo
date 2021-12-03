package controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import models.User;



public class EditProfileServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("editProfile.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int userId = Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		System.out.println(userId);
		User user = new User(userId,name,email,password,contact);
		user.editProfile();
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("signin.jsp");
	}
}
