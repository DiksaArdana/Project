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
 	<header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2">ABC Cars</h1>
                                <p class="lead fw-normal text-white-50 mb-4">Let Us Find What You are Looking For.</p>
                                
								<form action="search" method="get" class="input-group mb-3">
									<input type="text" class="form-control" name="keyword" placeholder="make or model" aria-label="car search" aria-describedby="button-addon2">
  									<button class="btn btn-outline-warning" type="submit" id="button-addon2">Search</button>
								</form>
								
                            </div>
                        </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5" src="img/Temp-600x300.png" alt="..." /></div>
                    </div>
                </div>
      </header>
      <section class="py-5 bg-light">
                <div class="container px-5 mb-3">
                    <div class="text-center">
                        <h2 class="fw-bolder">How To Buy </h2>
                    </div>
                    <div class="row gx-5 row-cols-1 row-cols-sm-2 row-cols-xl-4 justify-content-center">
                        <div class="col mb-5 mb-5 mb-xl-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://www.carsome.id/_nuxt/img/how-it-works-buy-1.b69149c.svg" alt="..." />
                                <h5 class="fw-bolder">Find Your Car</h5>
                                <div class="fst-italic text-muted">Find your dream car online that we have selected through a professional inspection process.</div>
                            </div>
                        </div>
                        <div class="col mb-5 mb-5 mb-xl-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://www.carsome.id/_nuxt/img/how-it-works-buy-2.1fefc56.svg" alt="..." />
                                <h5 class="fw-bolder">Test Drive</h5>
                                <div class="fst-italic text-muted">All of our cars have been sanitized before and after the test drive, to make your experience safe and comfortable.</div>
                            </div>
                        </div>
                        <div class="col mb-5 mb-5 mb-sm-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://www.carsome.id/_nuxt/img/how-it-works-buy-4.a9d3aca.svg" alt="..." />
                                <h5 class="fw-bolder">Direct Home Delivery</h5>
                                <div class="fst-italic text-muted">Choose to pick up your car at the nearest ABC Cars Center or we will deliver it directly to your home.</div>
                            </div>
                        </div>
                        <div class="col mb-5">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://www.carsome.id/_nuxt/img/how-it-works-buy-3.1d437d8.svg" alt="..." />
                                <h5 class="fw-bolder">Worry-Free Purchase</h5>
                                <div class="fst-italic text-muted">Enjoy a 5 day money back guarantee when you buy a car from ABC Cars.</div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
	
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>