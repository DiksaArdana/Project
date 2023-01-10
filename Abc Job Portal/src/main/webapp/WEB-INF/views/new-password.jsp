<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:
Function: 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
        <form method="post" id="resetPass" action="savePassword">
          <h1 class="h3 mb-3 fw-normal">Forget Password</h1>
          <div class="mb-3">
			<span class="err-msg">${error}</span>
		</div>
		<div class="mb-3">
			<span >${msg}</span>
		</div>
		  <div class="form-floating my-3">
		 	<input type="hidden" class="form-control" name="userID" id="userID" value="${user.userID}"/>
      	  </div>
          <div class="form-floating my-3">
            <input type="text" class="form-control" name="pass1" id="pass1"/>
            <label for="pass">New Password</label>
          </div> 
          <div class="form-floating my-3">
 			<input type="text" class="form-control" name="pass2" id="pass2"/>
 			<label for="confirmpassword">Confirm Password</label>
          </div>
			<button type="submit" class="w-100 btn btn-lg btn-colo my-3" id="save" name="save">Change Password</button>
        </form>

      </main>
</div>
	<%@ include file="footer.jsp"%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>