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
                        <h2 class="fw-bolder">User Profile </h2>
                    </div>
			<div class="row">
				<div class="col-md">
					
						<div class="card mb-3">
							<div class="row g-0">
							<div class="col-md-6">
									<div class="card-body p-5 fs-3">
										<h5 class="card-title text-center">${user.username}</h5><hr/>
										<p class="card-text">Name ${user.name} </p><hr/>
										<p class="card-text">Email ${user.email} </p><hr/>
										<p class="card-text">Phone Number ${user.phone}</p><hr/>
										
									</div>
								</div>
								<div class="col-md-6">
									<img
										src="/uploads/${user.image}"
										class="img-fluid p-3 mx-auto d-block rounded-circle" alt="..."
										width="400px">
										<c:if test="${dupe == null}">
											<sec:authorize access="hasAuthority('USER')">
												<a class="btn btn-info mx-auto d-block" href="/edit-profile" role="button"> Edit Profile </a>
											</sec:authorize>
											<sec:authorize access="hasAuthority('ADMIN')">
												<a class="btn btn-info mx-auto d-block" href="/edit-admin-profile" role="button">Edit Admin</a>
											</sec:authorize>
										</c:if>
								</div>
							</div>
						</div>

				</div>
			</div>
		</div>
       </section>
	
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>