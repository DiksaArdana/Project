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
                        <h2 class="fw-bolder">Cars page </h2>
                    </div>
			<div class="row">
				<div class="col-md-8 p-5 my-3 content-color">
					<c:forEach var="cars" items="${carlist}">
						<div class="card mb-3">
							<div class="row g-0">
								<div class="col-md-4">
									<img
										src="/uploads/${cars.image}"
										class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..."
										width="300px">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title"><i class="bi bi-car-front"></i> ${cars.make}</h5>
										<p class="card-text"><i class="bi bi-vinyl"></i> ${cars.model}</p>
										<p class="card-text"><i class="bi bi-pin-angle"></i> ${cars.registration}</p>
										<p class="card-text text-success">${cars.price} $</p>
										<p>
											<a class="btn btn-success px-3"
												href="/detail-car?id=${cars.id}" role="button"> View </a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
            </section>
	
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>