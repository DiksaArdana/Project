<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page: admin profile page
Function: display admin profile
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/mystyle.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>Profile</title>
</head>
<body>
<nav class="navbar navbar-expand-lg header-color navbar-light">
  <div class="container-fluid">
    <h1 class="text-dark">Portal</h1>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-3">
        <li class="nav-item">
            <a class="nav-link text-dark" href="dashboard">Dashboard</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="mailform">Email</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="jobboard">Jobs</a>
        </li>        
      </ul>
      <div class=" text-light fs-5 item-allign-center"> 
        <div class="navbar-nav dropdown">
            <a class="nav-link dropdown-toggle text-dark" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="bi bi-person-circle text-dark"></i> Admin
            </a>
            <ul class="dropdown-menu header-color" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
        </div>
    </div>
    </div>
  </div>
</nav>		
	<%-- <c:forEach var="user" items="${user.rows}"> --%>
	<div class="container py-3">
		<div class="row">
			<div class="col-lg-4">
				<div class="card mb-4 bg-crm">
					<div class="card-body text-center">
						<img src="https://www.pinclipart.com/picdir/big/181-1814767_person-svg-png-icon-free-download-profile-icon.png" alt="avatar" class="rounded-circle img-fluid"
							style="width: 150px;">
						<h5 class="my-3">${user.firstName} ${user.lastName}</h5>
						<p class="text-muted mb-4 h6">${user.workexp}</p>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="card mb-4">
					<div class="card-body bg-crm">
						<div class="row">
							<div class="col-sm-3">
								<p class="mb-0">Email</p>
							</div>
							<div class="col-sm-9">
								<p class="text-muted mb-0">${user.email}</p>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<p class="mb-0">Address</p>
							</div>
							<div class="col-sm-9">
								<p class="text-muted mb-0">${user.address}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- </c:forEach> --%>

	
	<%@ include file="footer.jsp"%>
	
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>