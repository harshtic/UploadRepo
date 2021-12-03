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
<%@ include file="header.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<form action="forgot.do" method="post">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">New Password</label>
						<input type="pass1" name="title" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">

					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Re-Enter Password</label>
						<input type="pass2" class="form-control"
							id="exampleInputPassword1">
					</div>
		
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>