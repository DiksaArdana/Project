<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:
Function: 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@ include file="header.jsp"%>

<div class="container ">
    <h3 class="text-center">Job List</h3>
        
    <div class="row">
    <div class="col-md-8 p-5 my-3 content-color">
                <c:forEach var="job" items="${listjob}">
					<div class="card mb-3">
                        <div class="row g-0">
                          <div class="col-md-4">
                            <img src="https://www.pinclipart.com/picdir/big/98-981218_docs-portfolio-briefcase-case-briefcase-clipart.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                              <h5 class="card-title">${job.jobTitle}</h5>
                              <p class="card-text">${job.company}</p>
                              <p class="card-text">${job.comAddress}</p>
                               <a href="seejob?id=${job.jobId}"><button class="btn btn-colo">More Detail</button></a>
                            </div>
                          </div>
                        </div>
                      </div>                
                </c:forEach>
		</div>
      <div class="col-md-4">
            <div class="container border my-3">
            <form method="get" id="jobs-sort" action="sort">
			<div class="mb-3">
				<h4 class="text-center">Sort By</h4>
				<div class="form-check">
					<input type="radio" class="form-check-input" value="Technology"
						name="sortValue" id="jobavailable"/> 
					<label class="form-check-label" for="jobavailable">Technology</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" value="marketing"
						name="sortValue" id="jobdisable"/> 
					<label class="form-check-label" for="jobdisable">Marketing</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input"  value="fashion"
						name="sortValue" id="jobdisable"/> 
					<label class="form-check-label" for="jobdisable">Fashion</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input"  value="pharmacy"
						name="sortValue" id="jobdisable"/> 
					<label class="form-check-label" for="jobdisable">Pharmacy</label>
				</div>
			</div>
			<button type="submit" class="w-100 btn btn-colo my-2" id="sortjob">Sort</button>
		</form>
        </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>