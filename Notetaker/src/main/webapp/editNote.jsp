<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.Note" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="head.jsp" %>
</head>
<body>

<%@ include file="header1.jsp" %>
 <%@ page import="models.Note" %>
    <%@ page import="java.util.*" %>



	<div class="container ">
		<div class="row mt-2">
			<div class="col-6 offset-3 mt-3">
			<%
						Note note = (Note)request.getAttribute("note");
					
					%>
				<form action="editNote.do?noteId=<%=note.getNote_id() %>" method="post" class="border border-1 p-5">
				<h3 class="text-danger my-1">Edit Notes</h3>
					<div class="mb-3">
					
						<label for="exampleInputEmail1" class="form-label">Title</label> 
						<input type="text" value="<%=note.getTitle() %>" name="title" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Description</label>
						<textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="10"><%=note.getDescription() %></textarea>
					</div>
					
					<button type="submit" class="btn btn-primary">Edit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>