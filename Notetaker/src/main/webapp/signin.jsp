<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <%@include file="head.jsp"%>
    <title>Notetaker::SignIn</title>
</head>

<%@ include file="header.jsp" %>
<div class="main-content">
    <div class="container-fluid">
        <div class="row ">
            <div class="col-5">
                <img src="static/images/sideimag.jpg" alt="does not load" width="500px" height="500px" class="m-3 my-5 mx-5">
            </div>
            <div class="col-6 ml-4 m-5" style="padding-left:6rem ">
            
                <h4 class="text-primary border-bottom border-primary f-head w-50 pb-2 mt-5 px-5 pt-3">SignIn</h4>
                <form action="signin.do" method="post" class=" w-50 ml-5 mt-4 " id="form">
                    <div class="form-group">
                        <label for="">Email</label>
                        <input type="email" name="email" id="" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Password</label>
                        <input type="password" name="password" id="" class="form-control">
                    </div>
                    <button class="btn btn-primary" id="btn">SignIn</button>
                    <p class="text-muted m-3">Don't?Have An Account <a class="text-decoration-none" href="signup.jsp">Signup</a>
                    </p>
                    <a href="forgot.jsp" class="text-secondary ml-3 btn">Forgot Password?</a>
                </form>
            </div>
        </div>
    </div>

</div>

<%@ include file="footer.jsp" %>

<body>

</body>

</html>

</body>
</html>