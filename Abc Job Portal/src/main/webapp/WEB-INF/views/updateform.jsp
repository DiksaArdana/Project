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

<div class="container">
    <div class="text-center" >
        <h2>Update Profile</h2>
        <img src="" alt="" width="200px" height="200px"><br>
        <a href="#" class="text-dark" role="button">Change picture</a>
    </div>
    <form method="post" class="border p-5 my-3" id="editProfile" action="../update">
    <%-- <c:forEach var="user" items="${listuser}"> --%>
    	<div class="mb-3">
			<input class="form-control" value="${user.userID}" name="userID" id="userID" hidden="hidden"/>
		</div>
        <div class=" mb-3">
            <label for="exampleFormControlInput1" class="form-label">Name</label>
            <div class="d-flex">
               <input type="text" class="form-control" value="${user.firstName}" name="firstName" id="firstName" placeholder="First name" />
                <input type="text" class="form-control" name="lastName" id="lastName" value="${user.lastName}" placeholder="Last name"/>
            </div>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Address</label>
            <input type="text" class="form-control" name="address" id="address" value="${user.address}" placeholder="City, Country"/>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Work Experience</label>
             <input type="text" class="form-control" name="workexp" id="workexp" value="${user.workexp}" />
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Education</label>
             <input type="text" class="form-control" name="education" id="education" value="${user.education}" />
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Certificate</label>
             <input type="text" class="form-control" name="cerificate" id="cerificate" value="${user.cerificate}" />
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Skill</label>
            <input type="text" class="form-control" name="skill" id="skill" value="${user.skill}" placeholder="Skills">
        </div> 
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button type="submit" class="btn btn-colo" id="update" name="update">Update</button>
          </div>
    <%-- </c:forEach> --%>
    </form>
</div>
<%@ include file="footer.jsp"%>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>