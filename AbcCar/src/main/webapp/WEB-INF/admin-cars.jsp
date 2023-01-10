<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" >
<title>ABC CARS</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
 	
      <section class="py-5 bg-light">
		<div class="container px-5 mb-3">
			<div class="text-center">
				<h2 class="fw-bolder">Admin Cars page</h2>
			</div>
			<div class="row">
				<div class="col-sm-12">
				<a class="btn btn-warning px-3" href="/admin"role="button">User Dashboard</a>
					<c:if test="${not empty carlists}">
						<table class="table table-hover table-striped">
							<thead class="text text-center">
								<tr>
									<th scope="col">CAR ID</th>
									<th scope="col">User ID</th>
									<th scope="col">Make</th>
									<th scope="col">Model</th>
									<th scope="col">Registration</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody class="text text-center">

								<c:forEach var="cars" items="${carlists}">

									<tr>
										
										<td class="pt-3">${cars.id}</td>
										<td class="pt-3">${cars.getUserId().getId()}</td>
										<td class="pt-3">${cars.make}</td>
										<td class="pt-3">${cars.model}</td>
										<td class="pt-3">${cars.registration}</td>
										<td class="pt-3">${cars.price} $</td>
										<td id="">
											<a class="btn btn-info px-3" href="/detail-car?id=${cars.id}"role="button">View</a>
											<form action="/update-status" method="post">
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
												<input type="hidden" name="carIds" value="${cars.id}" class="btn-logout dropdown-item"/>
												<button class="btn btn-lg btn-warning my-3" type="submit">Deactivate</button>
											</form>
										</td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>