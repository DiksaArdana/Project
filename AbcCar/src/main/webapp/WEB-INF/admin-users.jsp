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
				<h2 class="fw-bolder">Admin User page</h2>
			</div>
			<div class="row">
				<div class="col-sm-12">
				<a class="btn btn-warning px-3" href="/cars-list"role="button">Car Dashboard</a>
					<c:if test="${not empty userlists}">
						<table class="table table-hover table-striped">
							<thead class="text text-center">
								<tr>
									<th scope="col">User ID</th>
									<th scope="col">Full Name</th>
									<th scope="col">User Name</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody class="text text-center">

								<c:forEach var="user" items="${userlists}">

									<tr>
										
										<td class="pt-3">${user.id}</td>
										<td class="pt-3">${user.name}</td>
										<td class="pt-3">${user.username}</td>
										<td class="pt-3">${user.email}</td>
										<td class="pt-3">${user.phone}</td>
										<td id="">
											<a class="btn btn-info px-3" href="/user?id=${user.id}"role="button">View</a>
											<form action="/update-roles" method="post">
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
												<input type="hidden" name="userId" value="${user.id}" class="btn-logout dropdown-item"/>
												<button class=" btn btn-warning my-3" type="submit">Set As Admin</button>
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