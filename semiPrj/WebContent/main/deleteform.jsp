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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/delete.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">
	
  <title>Bon voyage</title>
</head>

<body style="background-color: #f8f8f8">
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a>
			</div>
		</nav>

<div class="container">
	<br><br><h3 style="text-align: center"><b>회원 탈퇴</b></h3>
</div>

	<div class="container">
		<div class="signin-container text-center">
			<div class="card border-0 shadow rounded-3 my-5">
				<div class="card-body p-10 p-sm-5">
						<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
							<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"></path>
						</svg>
						<br><br>
						<h6>탈퇴 하시겠습니까?</h6>
						
<form method="post" action="<%=request.getContextPath() %>/Delete.m"> 
<input type="hidden" name="id" value="${sessionScope.id}">

		<div class="mb-3">
			<input type="password" class="form-control" id="pw" name="pw" size="10" maxlength="10" placeholder="비밀번호">
		</div>
		
		<hr class="mb-4">
			<div class="text-center">
				<button class="btn btn-light btn-sm" type=submit>탈퇴</button>
				<button class="btn btn-light btn-sm" type=button onclick="history.go(-1)">취소</button>
			</div>
		</form>
			
				</div>
			</div>
		</div>
	</div>
</body>

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

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/main/idcheck.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/aos.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/imagesloaded.pkgd.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/jquery.animateNumber.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/jquery.waypoints.min.js"></script>
    <script src="<%=request.getContextPath()%>/main/js/custom.js"></script>
	
</body>
</html>