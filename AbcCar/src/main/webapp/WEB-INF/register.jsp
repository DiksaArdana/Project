<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
		<c:if test="${dupe != null}">
			<div class="alert alert-success">
				<p>${dupe}</p>
			</div>
		</c:if>
		<main class="form-signin w-100 m-auto p-5 bg-dark text-light"
			style="max-width: 350px;">
			<form:form class="form-signin" modelAttribute="user" method="post" action="save">
				<h2 class="form-signin-heading">Sign Up</h2>
				<label for="emailid" class="sr-only">Email</label> <form:input
					type="text" id="email" name="email" class="form-control" path="email"
					placeholder="example@email.com" required="required" autofocus="autofocus"/>
				<label for="fullName" class="sr-only">Full name</label> <form:input
					type="text" id="name" name="name" class="form-control"   path="name"
					placeholder="Full Name" required="required" autofocus="autofocus"/>
				<label for="userName" class="sr-only">Username</label> <form:input
					type="text" id="userName" name="username" class="form-control"  path="username"
					placeholder="Username" required="required" autofocus="autofocus"/>									
				<label for="password" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control" path="password"
					placeholder="Password" required="required">
				
				<input type="hidden"                          
        			name="${_csrf.parameterName}"  
        			value="${_csrf.token}"/> 
        		<button class="w-100 btn btn-lg btn-warning my-3" type="submit">Sign Up</button>
			</form:form>
			
		</main>
	</div>
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>