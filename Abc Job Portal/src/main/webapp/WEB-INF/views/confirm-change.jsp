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

            <h2>${title}</h2>
            <img src="img/correct.png" class="img-fluid p-5" alt="">
            <p>${error}</p>
            <p>${msg}</p>
            <a href="${pageContext.request.contextPath}/${link}">${linked}</a>

      </main>
</div>
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>