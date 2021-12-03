package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Note;

public class DeleteNoteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		int noteId = Integer.parseInt(request.getParameter("noteId"));
		Note.deleteNote(noteId);
		
		response.sendRedirect("Home.jsp");
		}

}
