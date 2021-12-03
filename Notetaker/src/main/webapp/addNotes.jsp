<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="head.jsp" %>
</head>
<body>

<%@ include file="header1.jsp" %>




	<div class="container ">
		<div class="row mt-2">
			<div class="col-6 offset-3 mt-3">
				<form action="addNotes.do" method="post" class="border border-1 p-5">
				<h3 class="text-danger my-1">Add Notes</h3>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Title
							</label> <input type="text" name="title" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
						
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Description</label>
						<textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="10"></textarea>
					</div>
					
					<button type="submit" id="showtoast" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	
	<div class="toast align-items-center text-white bg-dark" aria-atomic="true"  role="alert" aria-live="assertive">
		<div class="toast-body ml-5" id="mytoast">
			Note  added  successfully..
			<button class="close" data-dismiss="toast">
				<span class="text-white mb-2">&times;</span>				
			</button>
		</div>
	</div>
	
	<script>
		$(function(){
			$('#showtoast').click(function({
				$('.toast').toast('show');
			})
		});
	</script>

</body>
</html>