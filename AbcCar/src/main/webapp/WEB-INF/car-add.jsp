<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" >
<title>ABC CARS</title>
</head>
<body class="d-flex flex-column h-100 bg-light">
 <%@ include file="navbar.jsp"%>
 	<div class="container text-center py-5" style="min-height: 520px;">
 	    <c:if test="${email != null}">
                  <h5 class="bg-danger text-center">${email}</h5>
         </c:if>
         <c:if test="${msgPost != null}">
			<div class="alert alert-success">
				<p>${msgPost}</p>
			</div>
		</c:if>
		<main class="form-signin w-100 m-auto p-5 bg-dark text-light"
			style="max-width: 350px;">
			<form class="form-signin" method="post" action="/save-car" enctype="multipart/form-data">
				<h2 class="form-signin-heading">Post New Car</h2>
				<label for="imgcar" class="sr-only">Car Image</label> <input
					type="file" id="imgcar" accept="image/png, image/jpeg" name="file" class="form-control"
					required="required" autofocus="autofocus">
				<label for="carReg" class="sr-only">Registration Number</label> <input
					type="text" id="carRegnumber" name="carRegNumber" pattern="[A-Z]{3}[0-9]{4}[A-Z]{1}" title="For Example SGA1234A" class="form-control"
					placeholder="For Example SGA1234A" required="required" autofocus="autofocus">
				<label for="carName" class="sr-only">Car Name</label> 
				<select class="form-control" name="carName" required="required">
					<option disabled selected>Select Car</option>
					<option>BMW</option>
					<option>Maruti Suzuki</option>
					<option>Hyundai</option>
					<option>Tata</option>
					<option>Mahindra</option>
					<option>Kia</option>
					<option>Mercedes Benz</option>
					<option>Renault</option>
					<option>Honda</option>
					<option>MG Motor</option>
					<option>Nissan</option>
					<option>Datsun</option>
					<option>Toyota</option>
					<option>Skoda</option>
					<option>Ford</option>
					<option>Volkswagen</option>
					<option>Jeep</option>
					<option>ISUZU</option>
					<option>Audi</option>
					<option>Jaguar</option>
					<option>Volvo</option>
					<option>Lexus</option>
					<option>Land Rover</option>
					<option>Porsche</option>
					<option>Ferrari</option>
					<option>Rolls Royce</option>
					<option>Bentley</option>
					<option>DC</option>
					<option>Bugatti</option>
					<option>Force Motors</option>
					<option>Mitsubishi</option>
					<option>Bajaj</option>
					<option>Citroen</option>
					<option>Lamborghini</option>
					<option>MINI</option>
					<option>Aston Martin</option>
					<option>Maserati</option>
					<option>Tesla</option>
					<option>BYD</option>
					<option>Strom Motors</option>
					<option>ORA</option>
					<option>Haval</option>
				</select> 
				<label for="carModel" class="sr-only">Car Model</label> <input
					type="text" id="carModel" name="carModel" class="form-control"
					placeholder="Enter Car Model" required="required">
				<label for="carPrice" class="sr-only">Car Price</label> <input
					type="text" id="carPricel" name="carPrice" class="form-control"
					placeholder="Enter car price" required="required">
				<input type="hidden" id="carstatus" name="status" class="form-control" value="1">
				<input type="hidden"                          
        			name="${_csrf.parameterName}"  
        			value="${_csrf.token}"/> 
				<button class="w-100 btn btn-lg btn-warning my-3" type="submit">Post Car</button>
			</form>
		</main>
	</div>
<%@ include file="footer.jsp"%> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>   
</body>
</html>