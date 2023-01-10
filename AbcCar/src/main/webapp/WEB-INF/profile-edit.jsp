<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib prefix="email" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" >
<title>ABC CARS</title>
</head>
<body class="d-flex flex-column h-100 bg-light">
 <%@ include file="navbar.jsp"%>
 	<div class="container text-center py-5" style="min-height: 520px;">
 	    <email:if test="${email== true}">
                  <h5 class="bg-danger text-center">Registration Number Already Exists!</h5>
         </email:if>
		<main class="form-signin w-100 m-auto p-5 bg-dark text-light"
			style="max-width: 350px;">
			<form class="form-signin" method="post" action="/update-profile" enctype="multipart/form-data">
				<h2 class="form-signin-heading">Update user </h2>
				<label for="imgcar" class="sr-only">Profile Image</label> <input
					type="file" id="imgcar" accept="image/png, image/jpeg" name="file" class="form-control" 
					required="required" autofocus="autofocus" value="${user.image}">
					
					<input type="hidden" id="Id" name="userId"class="form-control" value="${user.id}">
					<input type="hidden" id="username" name="userName"class="form-control" value="${user.username}">
					
				<label for="username" class="sr-only">Username</label> <input
					type="text" id="username" name="username" class="form-control" value="${user.username}" disabled>
					
				<label for="fullname" class="sr-only">Full Name</label> <input
					type="text" id="fullname" name="fullName" class="form-control" required="required" autofocus="autofocus" value="${user.name}" >
					
				<label for="email" class="sr-only">Email</label> <input
					type="text" id="email" name="email" class="form-control" required="required" value="${user.email}">
					
				<label for="phone" class="sr-only">Phone Number</label> <input
					type="text" id="phone" name="phoneNumber" class="form-control" required="required" value="${user.phone}">
				
				<input type="hidden"                          
        			name="${_csrf.parameterName}"  
        			value="${_csrf.token}"/> 
				<button class="w-100 btn btn-lg btn-warning my-3" type="submit">Update Profile</button>
			</form>
		</main>
	</div>
<%@ include file="footer.jsp"%> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>   
</body>
</html>