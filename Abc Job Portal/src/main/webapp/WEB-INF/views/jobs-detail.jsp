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
    <h3 class="text-center">Job Detail</h3>
    <div class="row">
      <div class="col-md-4">
            
            	<div class="card mb-3 content-color">
                        <div class="row g-0">
                          <div class="col">
                            <img src="https://www.pinclipart.com/picdir/big/98-981218_docs-portfolio-briefcase-case-briefcase-clipart.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
                            <div class="card-body text-center text-light">
                              <h5 class="card-title">${job.jobTitle}</h5>
                              <p class="card-text">${job.company}</p>
                              <p class="card-text">${job.comAddress}</p>
                            </div>
                          </div>
                        </div>
                 </div> 
        </div>
        <div class="col-md-8 my-3">
                <div class="container">
					<div class="card mb-3">
                            <div class="card-body">
                              <h5 class="card-title">${job.jobTitle}</h5>
                              <p class="card-text">${job.company}, ${job.comAddress}</p>
                              <p class="card-text">${job.jobCategory}</p>
                              <p class="card-text">${job.jobDesc}</p>
                            </div>
                      </div>
        		</div>
        		<div class="container">
					 <form:form action="postapply" method="post" modelAttribute="jobapply">
              	
              		<input type="hidden" name="id" value="${job.jobId}" >
              	
                	<div class="form-floating">
                  		<form:textarea path="applyMessage" class="form-control" id="applyMessage"></form:textarea>
                  		<label for="floatingTextarea">Write your job apply message</label>
                	</div>
                <button type="submit" class="btn btn-colo my-3">Send</button>
              </form:form>               
        		</div>  
        </div>
	</div>
</div>
<%@ include file="footer.jsp"%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>