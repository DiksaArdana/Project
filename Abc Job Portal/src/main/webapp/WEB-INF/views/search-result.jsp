<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:
Function: 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<div class="container">
    <div class="row" >
    	<h3 class="text-center text-dark mb-3">Search List</h3>
        <div class="col-md border p-5 mb-3 content-color" >
            <p class = "text-light">${msgsearchResult}</p>
            <c:forEach var="user" items="${userlist}">
           <div class="card mb-3" >
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://www.pinclipart.com/picdir/big/181-1814767_person-svg-png-icon-free-download-profile-icon.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="Profile" width="200px">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h4 class="card-title">${user.firstName} ${user.lastName}</h4>
                            <p class="card-text">${user.education}</p>
                            <p class="card-text">${user.workexp}</p>                 
                            <a href="seeprofile/${user.userID}"><button class="btn btn-colo">See Profile</button></a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
