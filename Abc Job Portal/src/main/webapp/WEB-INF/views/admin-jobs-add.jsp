<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:add job page 
Function: from to save new job data to database
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h1 class="d-flex justify-content-center mb-5">Add Jobs</h1>

<div
		class="d-flex flex-wrap align-items-center justify-content-center bg-light mx-auto pt-3 pb-5 mb-5 rounded"
		style="width: 50%">
		<form:form method="post" class="col-8" id="admin-job-add"
			modelAttribute="job" action="savejob">
			<div class="mb-3">
				<form:hidden class="form-label" path="jobId"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputjobtitle" path="jobTitle">Job Title</form:label>
				<form:input type="text" class="form-control" path="jobTitle" name="jobTitle" id="jobTitle" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputjobcategory" path="jobCategory">Job Category</form:label>
				<form:input type="text" class="form-control" path="jobCategory" name="jobCategory" id="jobCategory" placeholder="Technology,Sience,Marekting"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputcompany" path="company">Company</form:label>
				<form:input type="text" class="form-control" path="company" name="company" id="company"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputcomaddress" path="comAddress">Company Address</form:label>
				<form:input type="text" class="form-control" path="comAddress" name="comAddress" id="comAddress"  placeholder="City, Country"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputjobdesc" path="jobDesc">Job Description</form:label>
				<form:textarea class="form-control" path="jobDesc" name="jobDesc" id="jobDesc" rows="10" />
			</div>
			<div class="mb-3">
				<label class="form-label">Status</label>
				<div class="form-check">
					<form:radiobutton class="form-check-input" path="status" value="1"
						name="flexRadioDefault" id="jobavailable"/> 
					<label class="form-check-label" for="jobavailable">Available</label>
				</div>
				<div class="form-check">
					<form:radiobutton class="form-check-input" path="status" value="2"
						name="flexRadioDefault" id="jobdisable"/> 
					<label class="form-check-label" for="jobdisable">Disable</label>
				</div>
			</div>
			<form:button type="submit" class="btn btn-colo" id="savejob" name="savejob">Save</form:button>
		</form:form>
	</div>
<%@ include file="footer.jsp"%>	

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>