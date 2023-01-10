<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:adduser page
Function: adding new user to the database
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
	<h1 class="d-flex justify-content-center mb-5">Administer User</h1>

	<div
		class="d-flex flex-wrap align-items-center justify-content-center bg-light mx-auto pt-3 pb-5 mb-5 rounded"
		style="width: 50%">
		<form:form method="post" class="col-8" id="admin-add"
			modelAttribute="user" action="save">
			<div class="mb-3">
				<form:hidden class="form-label" path="userID"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputfname" path="firstName">First Name</form:label>
				<form:input type="text" class="form-control" path="firstName"
					name="firstName" id="firstname" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputfname" path="lastName">Last Name</form:label>
				<form:input type="text" class="form-control" path="lastName" name="lastname" id="lastName" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputEmail" path="email">Email</form:label>
				<form:input type="text" class="form-control" path="email" name="email" id="email" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="inputPassword" path="pass">Password</form:label>
				<form:input type="password" class="form-control" path="pass" name="pass" id="password" />
			</div>
			<div class="mb-3">
            	<form:label for="exampleFormControlInput1" class="form-label" path="address">Address</form:label>
            	<form:input type="text" class="form-control" path="address" name="address" id="address"  placeholder="City, Country"/>
			</div>
			<div class="mb-3">
            	<form:label for="exampleFormControlTextarea1" class="form-label" path="workexp">Work Experience</form:label>
             	<form:input type="text" class="form-control" path="workexp" name="workexp" id="workexp"  />
			</div>
			<div class="mb-3">
            	<form:label for="exampleFormControlTextarea1" class="form-label" path="education">Education</form:label>
            	<form:input type="text" class="form-control" path="education" name="education" id="education"  />
			</div>
			<div class="mb-3">
            	<form:label for="exampleFormControlTextarea1" class="form-label" path="cerificate">Certificate</form:label>
            	<form:input type="text" class="form-control" path="cerificate" name="cerificate" id="cerificate" />
			</div>
			<div class="mb-3">
            	<form:label for="exampleFormControlInput1" class="form-label" path="skill">Skill</form:label>
            	<form:input type="text" class="form-control" path="skill" name="skill" id="skill" />
			</div>
			<div class="mb-3">
				<label class="form-label">Role</label>
				<div class="form-check">
					<form:radiobutton class="form-check-input" path="role" value="1"
						name="flexRadioDefault" id="softwareprogrammer"/> 
					<label class="form-check-label" for="softwareprogrammer">Software Programmer</label>
				</div>
				<div class="form-check">
					<form:radiobutton class="form-check-input" path="role" value="2"
						name="flexRadioDefault" id="flexRadioDefault2"/> 
					<label class="form-check-label" for="flexRadioDefault2">Administrator</label>
				</div>
			</div>
			<form:button type="submit" class="btn btn-primary" id="save"
				name="save">Save</form:button>
		</form:form>
	</div>
<%@ include file="footer.jsp"%>	

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>