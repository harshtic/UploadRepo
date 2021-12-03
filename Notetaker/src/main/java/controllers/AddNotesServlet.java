package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Note;
import models.User;

@SuppressWarnings("serial")
public class AddNotesServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		
		Note note = new Note();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		note.setDescription(description);
		note.setTitle(title);
		note.setuser(user);
		note.addNote();
		
		request.getRequestDispatcher("addNotes.jsp").forward(request, response);
		
	}


}
 