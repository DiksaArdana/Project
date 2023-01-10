<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:
Function: 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/mystyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>ABC Job Portal</title>
</head>
<body>
<nav class="navbar navbar-expand-lg header-color shadow fs-5">
  <div class="container-fluid">
  <div class="d-flex justify-content-between align-items-start">
    <div class="logo-web">
      <h1>Portal</h1>
    </div>
  </div>
  </div>
</nav>
<div class="container text-center py-5" style="min-height: 520px;">
    <main class="form-signin w-100 m-auto p-5 border" style="max-width: 350px;">
        <form:form method="post" id="loginForm" modelAttribute="loginDto" action="check">
          <h1 class="h3 mb-3 fw-normal">Login</h1>
		  <div class="mb-3">
			<span class="err-msg text-danger">${response}</span>
		  </div>
          <div class="form-floating my-3">
            <form:input type="text" class="form-control" path="email" name="email" id="email"/>
            <form:label class="form-label" for="inputEmail" path="email">Email</form:label>
          </div>

          <div class="form-floating">
            <form:input type="password" class="form-control" path="pass" name="pass" id="pass"/>
            <form:label class="form-label" for="inputPassword" path="pass">Password</form:label>
          </div>
          
			<form:button type="submit" class="w-100 btn btn-lg btn-colo my-3" id="login" name="login">Login</form:button>
          <a href="<%= request.getContextPath() %>/register" class="m-3 text-muted" >Create new account</a><br>
          <a href="forgetPassword" class="m-3 text-muted" >Forgot password?</a>
        </form:form>
      </main>
</div>
<%@ include file="footer.jsp"%>
    <script type="text/javascript" src="resources/js/validation.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>