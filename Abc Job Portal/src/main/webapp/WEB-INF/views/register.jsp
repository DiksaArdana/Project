<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page: register
Function: Register to make account for webiste
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <main class="form-signin w-100 m-auto p-5 border" style="max-width: 450px;">
       <form:form method="post" id="regForm" modelAttribute="user" action="registerProcess" onsubmit="return checkValidation()">
          <h1 class="h3 mb-3 fw-normal">Sign up</h1>
      
          <div class="form-floating my-3">
            <form:input type="text" class="form-control" path="email" name="email" id="email" />
            <form:label class="form-label" for="inputEmail" path="email">Email</form:label>
            <span class="err-msg">${dupe}</span>
          </div>

          <div class="d-flex gap-2 my-3">
          <div class="form-floating ">
          	<form:input type="text" class="form-control" path="firstName" name="firstName" id="firstname" />
            <form:label class="form-label" for="inputfname" path="firstName">First Name</form:label>
			<div class=" erform text-danger errorFname">First name invalid</div>
          </div>
          <div class="form-floating">
            <form:input type="text" class="form-control" path="lastName" name="lastName" id="lastName" />
            <form:label class="form-label" for="inputlname" path="lastName">Last Name</form:label>
            <div class=" erform text-danger errorLname">Last name invalid</div>
          </div>
          </div>

          <div class="form-floating">
            <form:input type="password" class="form-control" path="pass" name="pass" id="password" />
            <label class="form-label" for="inputPassword">Password</label>
            <div class=" erform text-danger errorPassword">Paswword invalid</div>
          </div>
          <div class="form-floating">
			<form:input type="text" class="form-control" id="role" path="role" hidden="hidden" value="1"/>
          </div>

          <form:button type="submit" class="w-100 btn btn-lg btn-colo my-3">Sign up</form:button>
        </form:form>

      </main>
</div>

<%@ include file="footer.jsp"%>

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/registration.js"></script>
</body>
</html>