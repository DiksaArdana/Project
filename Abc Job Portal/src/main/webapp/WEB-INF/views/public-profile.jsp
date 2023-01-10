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
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/mystyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>ABC Job Portal</title>
</head>
<body>
<%@ include file="header.jsp"%>

<%--<c:forEach var="user" items="${user}"> --%>
<div class="container">
    <h2 class="text-center my-3">User Information</h2>
    <div class="row">
        <div class="col-md-4">
            <div class="text-center" >
                <img class="img-fluid rounded-circle p-3 mx-auto d-block" src="https://www.pinclipart.com/picdir/big/181-1814767_person-svg-png-icon-free-download-profile-icon.png" alt="" width="100%" width="200px">
                <h3 >${user.firstName} ${user.lastName}</h3>
            </div>
        </div>
        <div class="col-md-8 my-3">
            <div class="row border mb-3">
                <div class="col-md p-3 content-color text-light">
                    <h3>Work Experience</h3>
                    <p>${user.workexp}</p>
                </div>
            </div>
            <div class="row border mb-3">
                <div class="col-md p-3 content-color text-light">
                    <h3>Education</h3>
                    <p>${user.education}</p>
                </div>
            </div>
            <div class="row border mb-3">
                <div class="col-md p-3 content-color text-light">
                    <h3>Certificate</h3>
                    <p>${user.cerificate}</p>
                </div>
            </div>
            <div class="row border mb-3">
                <div class="col-md p-3 content-color text-light">
                    <h3>Skills</h3>
                    <p>${user.skill}</p>
                </div>
            </div>
            <div class="row border mb-3">
                <div class="col-md p-3 content-color text-light">
                    <h3>Resume File</h3>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</c:forEach> --%>>
<%@ include file="footer.jsp"%>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>