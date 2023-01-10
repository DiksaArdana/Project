<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#/">
      			<img src="${pageContext.request.contextPath}/img/logo_light.png" alt="" width="80" height="74">ABC Cars
    		</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul
					class="navbar-nav ms-auto me-0 me-lg-auto fw-semibold text-uppercase">
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/">Home</a></li>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/cars">Car List</a></li>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/about">About Us</a></li>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/contact">Contact Us</a></li>		
				</ul>
				<div class="nav-button d-flex flex-column flex-lg-row mx-3">
				<sec:authorize access="!isAuthenticated()">
					<a href="login" class="btn btn-outline-warning me-0 me-lg-3 mb-3 mb-lg-0">Login</a>
					<a href="new" class="btn btn-warning mb-3 mb-lg-0">Register</a>
				</sec:authorize>
				
<!-- USER -->
				<sec:authorize access="isAuthenticated()">
				<div class="navbar-nav dropdown">
					<a class="nav-link dropdown-toggle text-dark" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> <i
						class="bi bi-person-circle text-light"></i><span class="text-light"> User</span>
					</a>
					<ul class="dropdown-menu bg-dark"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item text-light" href="/profile">Profile</a></li>
						<li>
							<sec:authorize access="hasAuthority('USER')">
									<a class="dropdown-item" href="/my-car"><span class="text-light">Dashboard</span></a>
							</sec:authorize> 
						</li>
						<li>
							<sec:authorize access="hasAuthority('ADMIN')">
									<a class="dropdown-item" href="/admin"><span class="text-light">User <br/> Dashboard</span></a>
							</sec:authorize>
						</li>
							<li><form action="${pageContext.request.contextPath}/logout" method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="submit" name="Logout"
										value="Logout" class="btn-logout dropdown-item text-light"></input>
								</form>
							</li>
					</ul>
				</div>
				</sec:authorize>
			</div>
			</div>
		</div>
	</nav>
	