<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="head.jsp" %>
    <title>Notetaker::Sign Up</title>
</head>

<body>
	  <%@ include file="header.jsp" %>

<div class="main-content">
    <div class="container-fluid">
        <div class="row ">
            <div class="col-5">
                <img src="static/images/sideimag.jpg" alt="does not load" width="500px" height="500px" class="m-3 my-5 mx-5">
            </div>
            <div class="col-6 ml-4 m-5" style="padding-left:6rem ">
            <% String errors = (String)request.getAttribute("errors"); %>	
                	<% if(errors!=null){ %>
	                	<h6 class="error">
	                		<%= errors %>
	                	</h6>
                	<% } %>	                                                                                                                  
                <h4 class="text-primary border-bottom border-primary f-head w-50 pb-2 px-5">SignUp</h4>
                <form action="signup.do" method="post" class=" w-50 ml-5 mt-4 " id="form">
               		<div class="form-group">
                        <label for="id_name">Name</label>
                        <input type="text" name="name" id="id_name" value="${param.name}" class="form-control" maxlength="50" minlength="5" autocomplete="off">
                        <small id="name_help" class="form-text text-muted pl-1">Characters Allowed: a-z, A-z, 0-9 and spaces.</small>
                        <small id="name_error" class="form-text text-danger pl-1 hide">Invalid Name. Please enter valid Name.</small>
                    </div>
						<input type="hidden" name="userTypeId" value="2" >
						<font size="" color=""></font>                
						<div class="form-group">
                        <label for="id_email">Email</label>
                        <input type="email" name="email" value="${param.email}" id="id_email" class="form-control">
                        <small id="email_help" class="form-text text-muted pl-1">Enter valid email.</small>
                        <small id="email_error" class="form-text text-danger pl-1 hide">Invalid Email. Please enter valid Email.</small>
                    </div>
                    <div class="form-group">
                        <label for="id_password">Password</label> <i onclick="view()" id="view_pass" class="fa fa-eye" aria-hidden="true"></i>
                        <input type="password" name="password" value="${param.password}"  id="id_password" class="form-control" maxlength="20" minlength="8">
                        <small id="password_help" class="form-text text-muted pl-1">Characters Allowed: a-z, A-z, 0-9, - and _.</small>
                        <small id="password_error" class="form-text text-danger pl-1 hide">Invalid Password. Please enter valid Password.</small>
						
                    </div>
                    <div class="form-group">
                        <label for="id_contact">Contact</label>
                        <input type="text" name="contact" id="id_contact" value="${param.contact}" class="form-control" minlength="10" maxlength="10" autocomplete="off">
                        <small id="contact_help" class="form-text text-muted pl-1">Characters Allowed: 0-9 and must start with 5-9.</small>
                        <small id="contact_error" class="form-text text-danger pl-1 hide">Invalid Contact. Please enter valid Contact.</small>
                    </div>

                     
                    
                    <button class="btn btn-primary" id="btn">SignUp</button>
                    <p class="text-muted m-3">Already?Have An Account
                        <a href="signin.jsp">Login</a>
                    </p>
                </form>
            </div>
        </div>
    </div>

</div>
 <script type="text/javascript" src="static/js/signup.js"></script> 

<%@ include file="footer.jsp" %>
 

</body>

</html>