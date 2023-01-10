<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:if test="${param.error}">
    	<h5 class="bg-danger text-center">Please Check Your Email And Password</h5>
    </c:if>
		<main class="form-signin w-100 m-auto p-5 bg-dark text-light"
			style="max-width: 350px;">
			<c:if test="${error_string != null}">

				<div class="alert alert-danger text-center">${error_string}</div>

			</c:if>
			<form class="form-signin" method="post" action="/loginUser">
				<h2 class="form-signin-heading">Sign in</h2>
				<label for="username" class="sr-only">Username</label> <input
					type="text" id="username" name="username" class="form-control"
					placeholder="Username" required="required" autofocus="autofocus">
				
					<label for="password" class="sr-only">Password</label> <input
						type="password" id="password" name="password" class="form-control"
						placeholder="Password" required="required">
				
				<input type="hidden"                          
        			name="${_csrf.parameterName}"  
        			value="${_csrf.token}"/> 
				<button class="w-100 btn btn-lg btn-warning my-3" type="submit">Signin</button>
			</form>
			<a href="<%= request.getContextPath() %>/new" class="m-3 text-light" >Create new account</a><br>
		</main>
	</div>
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>