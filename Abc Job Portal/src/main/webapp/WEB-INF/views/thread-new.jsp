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
                         <%--<c:forEach var="user" items="${user}"> --%>
                              <a href="newthread" class="text-light"><i class="bi bi-plus-circle"></i>Post Thread</a>
                         <%--</c:forEach> --%>
                              <a href="forum" class="text-light"><i class="bi bi-card-list"></i>Thread List</a>
                            </div>
                    </div>
				</div>
           </div> 
        </div>
        <div class="col-md-10 my-3">
                <div class="container">
					<div class="card mb-3">
                        <div class="row g-0">
                          <div class="col-md-4">
                            <img src="https://www.pinclipart.com/picdir/big/181-1814767_person-svg-png-icon-free-download-profile-icon.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                              <form:form method="post" class="col-8" id="thread-add" modelAttribute="thread" action="savethread">
                              	<div class="mb-3">
									<form:hidden class="form-label" path="threadID"/>
								</div>
								<div class="mb-3">
									<form:label class="form-label" for="inputthread" path="thread">Thread</form:label>
									<form:textarea class="form-control" path="thread" name="thread" id="thread" rows="4" />
								</div>
								<div class="mb-3">
									<form:label class="form-label" for="inputtags" path="tags">tags</form:label>
									<form:input type="text" class="form-control" path="tags" name="tags" id="tags"  placeholder="Java, Jobs, Technology, etc."/>
								</div>
								<form:button type="submit" class="btn btn-primary" id="savethread" name="savethread">Post</form:button>
                              </form:form>
                            </div>
                          </div>
                        </div>
                      </div>                
        		</div> 
        </div>
	</div>
</div>
<%@ include file="footer.jsp"%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>