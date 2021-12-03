package controllers;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Note;


public class ShowNoteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int noteId = Integer.parseInt(request.getParameter("note_id"));
		Note note = new Note(noteId);
		note.showNote(noteId);
		request.setAttribute("note", note);
		
		request.getRequestDispatcher("editNote.jsp").forward(request, response);
	
	}
}
