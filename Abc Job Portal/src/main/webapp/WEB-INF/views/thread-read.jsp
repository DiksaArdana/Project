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
    <h3 class="text-center">Thread</h3>
    <div class="row">
      <div class="col-md-2">
           <div class="card mb-3 content-color">
				<div class="row g-0">
					<div class="col">
                            <div class="card-body text-center text-light">
                        
                              <a href="newthread" class="text-light"><i class="bi bi-plus-circle"></i>Post Thread</a>
                        
                              <a href="my-thread" class="text-light"><i class="bi bi-card-list"></i>Thread List</a>
                            </div>
                    </div>
				</div>
           </div> 
        </div>
        <div class="col-md-10 my-3">
                <div class="container">
             
					<div class="card mb-3 content-color">
                        <div class="row g-0">
                          <div class="col-md-4">
                            <img src="https://www.pinclipart.com/picdir/big/181-1814767_person-svg-png-icon-free-download-profile-icon.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                              <h5 class="card-title text-light">${th.thread}</h5>
                              <p class="card-text text-light">${th.getUser().getFirstName()} ${th.getUser().getLastName()}</p>
                              <p class="card-text"><button class="btn border text-light">${th.tags}</button></p>
                        
                            </div>
                          </div>
                        </div>
                      </div>                
                <form:form action="postComment" method="post" modelAttribute="threadComment">
              	
              		<input type="hidden" name="id" value="${th.threadID}" >
              	
                	<div class="form-floating">
                  		<form:textarea path="comments" class="form-control" id="comments"></form:textarea>
                  		<label for="floatingTextarea">New Comment</label>
                	</div>
                <button type="submit" class="btn btn-colo my-3">Reply</button>
              </form:form>
              
               <c:forEach items="${listComment}" var="comment">
			    <div class="card border mb-3">
                 <div class="card-body">
                 	<b>${comment.getUser().getFirstName()} ${comment.getUser().getLastName()}</b>
                  	<p class="text-secondary mt-2 m-0 p-0">${comment.getComments()}</p>
                 </div>
              </div>
			  </c:forEach>
        		</div> 
        </div>
	</div>
</div>
<%@ include file="footer.jsp"%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>