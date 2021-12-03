<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.Note" %>
    <%@ page import="java.util.*" %>
    <%@ page import="controllers.ShowNotesServlet" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ include file="head.jsp" %>

</head>
<body>
	<%@ include file="header1.jsp" %>
	


	<div class="Notes my-4">
		<div class="container mt-5">

<div class="row">
			<%	
			ArrayList<Note> notes = new Note().getAllNotes(user);
			if(notes!=null)
				for(Note note : notes){	
			%>
				<div class="col-8  offset-2 mb-4">
					<div class="card ">
						<div class="card-body ">
							<p id="note_id" class="d-none"><%=note.getNote_id() %></p>
							<h5 class="card-title text-primary"><%=note.getTitle() %></h5>
							<p class="card-text"><%=note.getDescription() %></p>
							<a class="btn btn-primary btn-sm" href="showNote.do?note_id=<%=note.getNote_id()%>" class="card-link">Edit</a>
							<a class="btn btn-danger btn-sm" class="deleteNotes" class="card-link">delete</a>
						</div>
					</div>
				</div>	
		<% } %>
			</div>	
		</div>
	</div>
	
	<script type="text/javascript" src="static/js/home.js"></script> 
</body>
</html>