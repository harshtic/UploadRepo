<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="models.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="head.jsp" %>
</head>
<body>
<div class="header" >
		<div class="container-fluid" >
			<div class="row bg-dark nav" style="height:60px;">
				<div class=" col-7 ">
					<img src="static/images/library_logo.png " width="48px " height="48px ">
					
					<h2 class="text-white">Notetaker</h2>
				</div>
				
				<div class="col-5">
					<div class="btn float-right py-3 w-100 px-5">
						<ul class=" list-unstyled ">
							<li class="text-white d-inline"><a href="addNotes.jsp" class=" text-white text-decoration-none"><i class="far fa-plus-square mr-1">Add Notes</i></a></li>
							
							<li class="text-white  d-inline ml-5 "><i
								class="fas fa-sign-out-alt"></i><a
								class=" text-white text-decoration-none" href="logout.do">Logout</a></li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container ">
		<div class="row mt-2">
			<div class="col-6 offset-3 mt-3">
				<% User user = (User)session.getAttribute("user"); %>
				<form action="editProfile.do?userId=<%=user.getId() %>" method="post" class="border border-1 p-5">
				<h3 class="text-danger my-1">Edit Profile</h3>
			
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Name
							</label> <input type="text" value="<%=user.getName() %>" name="name" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email
							</label> <input type="email" value="<%=user.getEmail() %>" name="email" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Password
							</label> <input type="text" value="<%=user.getPassword() %>" name="password" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Contact
							</label> <input type="text" value="<%=user.getContact() %>" name="contact" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	



</body>
</html>