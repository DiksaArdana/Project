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
                        <h2 class="fw-bolder">Cars Detail page </h2>
                   </div>
			<c:if test="${bookmsg != null}">
				<div class="alert alert-success">
					<p>${bookmsg}</p>
				</div>
			</c:if>
			<div class="row">
				<div class="col-md">
					
						<div class="card mb-3">
							<div class="row g-0">
							<div class="col-md-6">
									<div class="card-body p-5 fs-3">
										<h5 class="card-title"><i class="bi bi-car-front"></i> ${car.make}</h5><hr/>
										<p class="card-text"><i class="bi bi-vinyl"> </i>${car.model} Model</p><hr/>
										<p class="card-text"> Registration number ${car.registration}</p><hr/>
										<p class="card-text">Price <span class="text-success">${car.price}</span></p><hr/>
										<p>
											<a class="btn btn-success px-3"
												href="#_bid" role="button"> Start Bidding </a>
										</p>
										<form action="/booking" method="post" class="input-group mb-3">
											<input type="hidden" name="id" value="${car.id}" /> 
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<input type="text" class="form-control" name="keydate" placeholder="DD/MM/YYYY" 
											pattern="[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}" title="For Example DD/MM/YYYY"
											aria-label="car search" aria-describedby="button-addon2">
  											<button class="btn btn-info" type="submit" id="button-addon2">Book Test Drive</button>
										</form>
									</div>
								</div>
								<div class="col-md-6">
									<img
										src="/uploads/${car.image}"
										class="img-fluid p-3 mx-auto d-block" alt="..."
										width="500px">
								</div>
							</div>
						</div>

				</div>
			</div>
			<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h3 class="text-center pt-3" >Current Bidding Price!</h3>
				<form action="/car_bidding" method="post" class="input-group mb-3">
					<input type="hidden" name="id" value="${car.id}" /> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input class="form-control" id="bidding-search" type="text"
						name="bitprice" placeholder="Add Price..." aria-describedby="button-addon2"> 
					<button class="btn btn-success" type="submit" id="button-addon2" name="bid">Bidding</button>
				</form>
				<table class="table table-striped text-center" id="_bid">
					<thead>
						<tr>
							<th>No.</th>
							<th>Username</th>
							<th>Price</th>
							<th>Date</th>
							<c:if test="${dupe != null}"><th>Action</th></c:if>
							
						</tr>
					</thead>
					<tbody>
						<% int i=1; %>
						<c:forEach var="car_bidding" items="${bidinfo}">
							<tr>
								<td class="pt-3"><%=i %></td>
								<td class="pt-3">${car_bidding.bidderName}</td>
								<td class="pt-3">${car_bidding.bidderPrice}</td>
								<td class="pt-3">${car_bidding.bid_date_time}</td>
								<c:if test="${dupe != null}">
									<td class="pt-3"><a class="btn btn-info px-3" href="/user-detail?id=${car_bidding.getUser().getId()}" role="button">View</a></td>
								</c:if>
							</tr>
							<% i++; %>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${dupe != null}">
				<h3 class="text-center pt-3" >Test Drive Booking</h3>
				<table class="table table-striped text-center" id="_drive">
					<thead>
						<tr>
							<th>No.</th>
							<th>Date</th>
							<th>CarId</th>
							<th>CarModel</th>
							<th>Email</th>
							<th>Action</th>
							
						</tr>
					</thead>
					<tbody>
						<% int x=1; %>
						<c:forEach var="car_book" items="${bookinfo}">
							<tr>
								<td class="pt-3"><%=i %></td>
								<td class="pt-3">${car_book.date}</td>
								<td class="pt-3">${car_book.getCar().getId()}</td>
								<td class="pt-3">${car_book.getCar().getModel()}</td>
								<td class="pt-3">${car_book.getUser().getUsername()}</td>
								<c:if test="${dupe != null}">
									<td class="pt-3"><a class="btn btn-info px-3" href="/user-detail?id=${car_book.getUser().getId()}" role="button">View</a></td>
								</c:if>
							</tr>
							<% x++; %>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
			</div>
			<div class="col-sm-3"></div>
		</div>
		</div>
       </section>
	
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>