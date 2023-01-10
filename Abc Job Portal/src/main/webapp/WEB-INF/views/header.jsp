<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page: For every page when user login  
Function: navigate between page
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg header-color navbar-light">
  <div class="container-fluid">
    <a href="${pageContext.request.contextPath}/jobs" class="nav-link"><h1 class="text-dark">Portal</h1></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-3">
        <li class="nav-item mx-3">
            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/search-user"><i class="bi bi-search"></i> Search</a>
        </li>
        <li class="nav-item mx-3">
            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/jobs"><i class="bi bi-briefcase"></i> Jobs</a>
        </li>
        <li class="nav-item mx-3">
            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/forum"><i class="bi bi-people"></i> Forum</a>
        </li>
      </ul>
      <div class=" text-light fs-5 item-allign-center"> 
        <div class="navbar-nav dropdown">
            <a class="nav-link dropdown-toggle text-dark" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="bi bi-person-circle text-dark"></i> User
            </a>
            <ul class="dropdown-menu header-color" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Profile</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
        </div>
    </div>
    </div>
  </div>
</nav>
</body>
</html>