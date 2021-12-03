package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Note;


public class EditNoteServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	
	int noteId =Integer.parseInt(request.getParameter("noteId"));
	String title=request.getParameter("title");
	String description=request.getParameter("description");
	Note note = new Note(noteId,title,description);
	note.editNote();
	response.getWriter().write("success");
	response.sendRedirect("Home.jsp");
	}
}
