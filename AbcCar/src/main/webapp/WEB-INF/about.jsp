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
 	<!-- Header-->
            <header class="py-5" style="background:url(img/Temp-500x300.png) no-repeat center fixed; background-size: cover;">
                <div class="container px-5">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-xxl-6">
                            <div class="text-center my-5 text-light">
                                <h1 class="fw-bolder mb-3">About Us</h1>
						<p class="lead fw-normal text-light mb-4">ABC Cars is the
							largest online used car buying and selling platform in Southeast
							Asia, currently present in Malaysia, Indonesia, Thailand and
							Singapore. The company's mission is to bring the used car
							industry into the digital age by building and leveraging
							experience in selling and buying cars.</p>
					</div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- About section one-->
            <section class="py-5 bg-light" id="scroll-target">
                <div class="container px-5 my-5">
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6"><img class="img-fluid rounded mb-5 mb-lg-0" src="https://www.carsome.id/_nuxt/img/image-2.4afa2a6.jpg" alt="..." /></div>
                        <div class="col-lg-6">
                            <h2 class="fw-bolder">The ABC Cars Vision</h2>
					<p class="lead fw-normal text-muted mb-0">Our vision is to
						provide a smooth car buying and selling journey for Southeast
						Asia. At car sales, everything we do from product development to
						marketing and communications aims to empower our customers and give
						them greater confidence when it comes to trading cars regardless
						of how much they know about cars or how engaged they might be in
						the process.</p>
				</div>
                    </div>
                </div>
            </section>
            <section class="py-5">
            <div class="container px-5 my-5">
            <div class="row gx-4 gx-lg-5">
            <h2 class="fw-bolder text-center">Our Service</h2>
                <div class="col-md-6 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                        <span><img src="img/buy_icon.png" alt="" width="80" height="74"></span>
                            <h2 class="card-title"> Buying</h2>
                            <p class="card-text">
                             <ul>
                    			<li>Over 200,000 new and used cars to choose from on <a href="/">ABC Cars</a></li>
                    			<li>Tools to help you find, compare and decide</li>
                   				 <li>The latest new car deals and <a href="#">special offers</a> from manufacturers</li>
                			</ul>
                            </p>
                        </div>                   
                    </div>
                </div>
                <div class="col-md-6 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                        <span><img src="img/sell_icon (1).png" alt="" width="80" height="74"></span>
                            <h2 class="card-title">Selling</h2>
                            <p class="card-text">
            
                				<ul>
                   					<li>Choose from Lite, Standard, Premium or Ultimate <a href="#">ad types</a></li>
                    				<li>Sell in a snap by listing your car straight from your mobile</li>
                    				<li>Tools to help you sell with confidence</li>
                    				<li>PrivacyProtect for anonymity and added security</li>
                				</ul>
                            </p>
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