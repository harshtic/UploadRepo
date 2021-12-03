
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@ page import="models.User" %>
<%
	User user = (User)session.getAttribute("user");
	if(user==null){
		response.sendRedirect("signin.jsp");
	}
	
%>

	<div class="header" >
		<div class="container-fluid" >
			<div class="row bg-dark nav" style="height:60px;">
				<div class=" col-6 ">
					<img src="static/images/library_logo.png " width="48px " height="48px ">
					
					<h2 class="text-white">Notetaker</h2>
				</div>
				<div class="col-6">
					<div class="btn float-right py-3 w-100 px-5">
						<ul class=" list-unstyled ">
							<li class="text-white d-inline"><a href="addNotes.jsp" class=" text-white text-decoration-none"><i class="far fa-plus-square mr-1">Add Notes</i></a></li>
							<li class="text-white d-inline ml-3" ><a href="Home.jsp" class=" text-white text-decoration-none" ><i class="far fa-plus-square mr-1">Show Notes</i></a></li>
							<li class="text-white  d-inline ml-4" data-toggle="modal"
								data-target="#profileModal"><i
								class="fa fa-user-circle mr-1"></i><a
								class="text-white text-decoration-none"><%=user.getName() %></a></li>
							<li class="text-white  d-inline ml-5 "><i
								class="fas fa-sign-out-alt"></i><a
								class=" text-white text-decoration-none" href="logout.do">Logout</a></li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="profileModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header  bg-primary text-white">
					<h5 class="modal-title" id="exampleModalLabel">Profile</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
					<%System.out.print(user.getPic()); %>
						<img alt="Not available" src="static/images/<%=user.getPic()%>" width="150px" height="150px" style="border-radius:50%">
							<form action="uploadpic.do?userId=<%=user.getId() %>" method="post" enctype="multipart/form-data">
									<input type="file" name="pic" /> 
							<input type="submit" value="Upload" />
							</form>
							
						<h5 class="modal-title mt-3"><%=user.getName() %></h5>

						<table class="table mt-2">
							<tbody>
								<tr>
									<th scope="row">Id:</th>
									<td id="userId"><%=user.getId()%></td>
								</tr>

								<tr>
									<th scope="row">Email:</th>
									<td><%=user.getEmail()%></td>
								</tr>

								<tr>
									<th scope="row">Password:</th>
									<td><%=user.getPassword()%></td>
								</tr>

								<tr>
									<th scope="row">Contact:</th>
									<td><%=user.getContact()%></td>

								</tr>

							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">
						<a class="text-white text-decoration-none" href="editProfile.do">Edit</a>
					</button>
				</div>
			</div>
		</div>
	</div>
	
