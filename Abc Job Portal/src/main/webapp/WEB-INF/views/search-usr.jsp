<!-- 
Name:Ida Bagus Gde Diksa Ardana
Page:
Function: 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div class="my-3 px-5">
        <h3>Search User:</h3>
        <form action="search" method="get">
        	<input type="text" class="form-control" placeholder="Search..." aria-label="Search" name="searchValue" id="searchValue">
        	<button class="btn btn-outline-warning" type="submit"><i class="bi bi-search"></i></button>
        </form>
    </div>
    <img src="https://www.pinclipart.com/picdir/big/552-5526663_find-customers-graphic-design-clipart.png" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="400px">
    <h3 class="text-center my-3">Search other user</h3>
</div>
<%@ include file="footer.jsp"%>	
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>