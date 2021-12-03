package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class BServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name+" "+email);
		response.sendRedirect("index.html");
	}

}
