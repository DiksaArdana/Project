
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
<nav class="navbar navbar-expand-lg header-color shadow fs-5">
    <div class="container-fluid">
    <div class="d-flex justify-content-between align-items-center">
      <div class="logo-web">
        <h1>Portal</h1>
      </div>
    </div>
        <div class=" fs-5 item-allign-center"> 
          <div class="d-flex gap-2" role="user">
            <a href="<%= request.getContextPath() %>/login"><button class="btn btn-colo">Login</button></a>
            <a href="<%= request.getContextPath() %>/register"><button class="btn btn-outline-dark" type="submit">Register</button></a>
          </div>
        </div>
    </div>
</nav>

<div class="p-5" style="background-image:url(img/Banner.jpg); background-size: cover;min-height: 480px;">
    <div class="container-fluid py-5">
      <h2 class="display-5 fw-bold">Find job that matters to you</h2>
      <p class="col-md-8 fs-4">Get motivation and tools you need to get ahead.</p>
      <a href="<%= request.getContextPath() %>/register"><button class="btn btn-colo btn-lg">Join Now</button></a>
    </div>
</div>

<div class="content-color py-3">
    <h2 class="text-light text-center ">Tools to help you get ahead</h2>
<div class="container content-color">
    <div class="card mb-3">
        <div class="row g-0">
          <div class="col-md-2">
            <img src="img/united.png" class="img-fluid rounded-start p-3 mx-auto d-block" alt="..." width="200px">
          </div>
          <div class="col-md-10 d-flex align-items-center">
            <div class="card-body">
              <h5 class="card-title">Helpful community</h5>
              <p class="card-text">Milion of workers just like you, helping each other get to work</p>
              <a href="<%= request.getContextPath() %>/login">Search user</a>
            </div>
          </div>
        </div>
      </div>
      <div class="card mb-3">
        <div class="row g-0">
          <div class="col-md-2">
            <img src="img/job.png" class="img-fluid rounded-start p-3 mx-auto d-block" alt="..." width="200px">
          </div>
          <div class="col-md-10 d-flex align-items-center">
            <div class="card-body">
              <h5 class="card-title">Find job  and faster</h5>
              <p class="card-text">All the listings from various company in one place</p>
              <a href="<%= request.getContextPath() %>/login">Explore job</a>
            </div>
          </div>
        </div>
      </div>
      <div class="card mb-3">
        <div class="row g-0">
          <div class="col-md-2">
            <img src="img/certificate.png" class="img-fluid rounded-start p-3 mx-auto d-block" alt="..." width="200px">
          </div>
          <div class="col-md-10 d-flex align-items-center">
            <div class="card-body ">
              <h5 class="card-title">Building towards better</h5>
              <p class="card-text">Build profile to take your next job to the next level</p>
              <a href="<%= request.getContextPath() %>/login">Start my profile</a>
            </div>
          </div>
        </div>
      </div>
</div>
</div>
<div class="container">
<div class="row" >
    <h2 class=" text-center py-3">Celebrate the hustle</h2>
    <div class="col-md">
        <div class="card mb-3">
            <div class="row g-0">
              <div class="col-md-4">
                <img src="img/Dubu.jpg" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Kim Dahyun</h5>
                  <p class="card-text">Every time I go onto Jobcase I learn something new from other members.</p>
                </div>
              </div>
            </div>
          </div>
    </div>
     <div class="col-md">
        <div class="card mb-3">
            <div class="row g-0">
              <div class="col-md-4">
                <img src="img/in youp.jpg" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Hwang Berry</h5>
                  <p class="card-text">The experience on Jobcase feels very personalized and the members are like a support team.</p>
                </div>
              </div>
            </div>
          </div>
    </div>
     <div class="col-md">
        <div class="card mb-3">
            <div class="row g-0">
              <div class="col-md-4">
                <img src="img/jae.jpg" class="img-fluid rounded-circle p-3 mx-auto d-block" alt="..." width="200px">
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title">Jae Jae</h5>
                  <p class="card-text">ABC job is a safe environment and the best place to go if you are looking for a job.</p>
                </div>
              </div>
            </div>
          </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp"%>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>