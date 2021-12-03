package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import models.Note;
import models.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ShowNotesServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		Note note = new Note();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		
		String resp=null;
		if(user!=null) {
			ArrayList<Note> getAllNotes = note.getAllNotes(user);
			request.setAttribute("getAllNotes", getAllNotes);
			
			
			Gson gson= new Gson();
			resp = gson.toJson(getAllNotes);
			 
		}
		
		response.getWriter().write(resp);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	
	}

}
