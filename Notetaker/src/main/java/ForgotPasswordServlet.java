import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

public class ForgotPasswordServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		if(pass1==pass2) {
			User user = new User();
			user.setPassword(pass1);
		}
		
		
	}
}
