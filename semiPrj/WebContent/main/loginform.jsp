<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

  <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/fonts/icomoon/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/fonts/flaticon/font/flaticon.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/aos.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/login.css">
	
  <title>Bon voyage</title>
</head>

<body style="background-color: #f8f8f8">
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a>
				<ul class="navbar-nav">
				    <li class="nav-item">
	              		<a class="nav-link" href="<%=request.getContextPath()%>/Q_ListAction.q">
			              	<svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
							  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"></path>
							</svg>
			              	<b>고객센터</b>
              			</a>
              		</li>
				</ul>
			</div>
		</nav>

<div class="container">
	<br><br><h3 style="text-align: center"><b>로그인</b></h3>
</div>

     <div class="container">
      <div class="login-container">
       <div class="card border-0 shadow rounded-3 my-5">
         <div class="card-body p-10 p-sm-5">
			 <form method="post" action="<%=request.getContextPath()%>/Login.m" class="loginform">	
              <input type="text" id="Id" name="id" class="form-control" placeholder="ID">
              <input type="password" id="Pw" name="pw" class="form-control" placeholder="password">
              <hr class="mb-4">              
						<button class="btn btn-light btn-sm btn-block" type="submit">로그인</button>
						<button class="btn btn-light btn-sm btn-block" type="button" onClick="location.href='<%=request.getContextPath()%>/joinform.m' ">회원가입</button>
      	   			</form>
				</div>
			</div>
		</div>
	</div>
	
    <div class="site-footer">
		<div class="container">
			<div class="row justify-content-center copyright">
				<div class="col-lg-7 text-center">

					<div class="widget">
						<ul class="social list-unstyled">
							<li><a href="#"><span class="icon-facebook"></span></a></li>
							<li><a href="#"><span class="icon-twitter"></span></a></li>
							<li><a href="#"><span class="icon-linkedin"></span></a></li>
							<li><a href="#"><span class="icon-youtube-play"></span></a></li>
						</ul>
					</div>

					<div class="widget">
						<p>
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with 
							love by <a href="https://untree.co" target="_blank" rel="nofollow noopener">Untree.co</a> &bullet; <a 
							href="https://untree.co/license" target="_blank" rel="nofollow noopener">License</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="overlayer">
		<div class="loader">
			<div class="spinner-border" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
	</div>
 
    <script src="<%=request.getContextPath()%>/main/js/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/aos.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/imagesloaded.pkgd.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/jquery.animateNumber.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/jquery.waypoints.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/custom.js"></script>

  </body>
</html>