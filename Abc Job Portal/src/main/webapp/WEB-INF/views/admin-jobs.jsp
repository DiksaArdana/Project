<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page: job board page 
Function: display job data from database
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
<title>ABC Admin</title>
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
              <li><a class="dropdown-item" href="../logout">Logout</a></li>
            </ul>
        </div>
    </div>
    </div>
  </div>
</nav>	
	
	<h1 class="d-flex justify-content-center mb-5">Administer Jobs</h1>
	<div class="container mb-4">
		<button type="button" onclick="window.location.href='addjob';" class="btn btn-colo">Add Job</button>
		<p>${msg}</p>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Category</th>
				<th>Company</th>
				<th>Address</th>
				<th>Description</th>
				<th>Status</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="job" items="${listjob}">
				<tr>
					<td>${job.jobId}</td>
					<td>${job.jobTitle}</td>
					<td>${job.jobCategory}</td>
					<td>${job.company}</td>
					<td>${job.comAddress}</td>
					<td>${job.jobDesc}</td>
					<td>${job.status}</td>
					<td><a href="editjob/${job.jobId}">Edit</a></td>
					<td><a href="deletejob/${job.jobId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp"%>	

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>