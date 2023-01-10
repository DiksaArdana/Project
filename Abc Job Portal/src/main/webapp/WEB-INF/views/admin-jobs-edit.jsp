<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:edit job page
Function: edit job data that already exist
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mystyle.css" rel="stylesheet">
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
            <a class="nav-link text-dark" href="../dashboard">Dashboard</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="../mailform">Email</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="../jobboard">Jobs</a>
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
	<h1 class="d-flex justify-content-center mb-5">Administer Edit User</h1>

	<div
		class="d-flex flex-wrap align-items-center justify-content-center bg-light mx-auto pt-3 pb-5 mb-5 rounded"
		style="width: 50%">
		<form method="post" class="col-8" id="editForm" action="../edit-jobs">
		<%-- <c:forEach var="job" items="${listjob}"> --%>
			<div class="mb-3">
				<label class="form-label" for="inputid">Job ID</label>
				<input class="form-control" value="${job.jobId}"
					name="dispuserID" id="dispuserID" disabled="disabled"/>
				<input class="form-control" value="${job.jobId}"
					name="jobId" id="jobId" hidden="hidden"/>
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobtitle">Job Title</label>
				<input type="text" class="form-control" value="${job.jobTitle}"name="jobTitle" id="jobTitle" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobcategory">Job Category</label>
				<input type="text" class="form-control" value="${job.jobCategory}"name="jobCategory" id="jobCategory" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobcompany">Company</label>
				<input type="text" class="form-control" value="${job.company}"name="company" id="company" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobcompany">Company Address</label>
				<input type="text" class="form-control" value="${job.comAddress}"name="comAddress" id="comAddress" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobcompany">Job Description</label>
				<textarea class="form-control" name="jobDesc" id="jobDesc" rows="10">${job.jobDesc}</textarea>
			</div>
			<div class="mb-3">
				<label class="form-label" for="inputjobstatus">Status</label>
				<input type="text" class="form-control" value="${job.status}"name="status" id="status"/>
			</div>

			<button type="submit" class="btn btn-primary" id="edit-jobs"
				name="edit-jobs">Save</button>
		<%-- </c:forEach> --%>
		</form>

	</div>
	
<%@ include file="footer.jsp"%>	

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>