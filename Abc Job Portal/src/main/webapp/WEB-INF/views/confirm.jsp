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
    <main class="form-signin w-100 m-auto p-5 border" style="max-width: 450px;">

          <h2>Thank You! ${firstName}</h2>
          <img src="img/email.png" class="img-fluid p-5" alt="">
          <p>Your email has already been confirmed. now you can login</p>
          <a href="${pageContext.request.contextPath}/login">Back to Login Page</a>

      </main>
</div>

<footer class="header-color p-3">
    <div class="d-flex mb-3">
      <div>© Portal, Inc. 2022 All rights reserved.</div>
      <div class="ms-auto text-light fs-5"> 
        <ul class="list-group list-group-horizontal-md header-color">
          <li class="list-group-item header-color "><a href="instagram.com" class="text-dark" target="_blank"><i class="bi bi-instagram "></i>portal</a></li>
          <li class="list-group-item header-color "><a href="facebook.com" class="text-dark " target="_blank"><i class="bi bi-facebook "></i>portal</a></li>
          <li class="list-group-item header-color "><a href="twitter.com" class="text-dark" target="_blank"><i class="bi bi-twitter "></i>portal</a></li>
        </ul>
      </div>
    </div>
  </footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>