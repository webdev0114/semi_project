<%@ page language="java" contentType="text/html; charset=utf-8"%>

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

<title>Bon voyage</title>
</head>
  <body style="background-color: #f8f8f8">
	<nav class="navbar navbar-expand-lg navbar-light">
	  	<div class="container">
			    <a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a> 
				      	<ul class="navbar-nav ml-auto">
							<li class="nav-item">
						      <a class="nav-link" href="<%=request.getContextPath()%>/Logout.m">
								<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
								  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
								  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
								</svg><b>&nbsp;로그아웃</b>
								</a>
						    </li>
				    <li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/Mypage.m">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
					  			<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
							</svg><b>마이페이지</b>
						</a>
					</li>
				</ul>
			</div>
		</nav>
			
		<br><br><br>

<body class="text-center"> 
	<div class="container">
		<div class="signin-container">
			<div class="card border-0 shadow rounded-3 my-5">
				<div class="card-body p-10 p-sm-5">

<form action="<%=request.getContextPath() %>/R_Delete.r" method="post" >

<input type="hidden" name="r_num" value="${param.r_num }"> 														
<input type="hidden" name="page" value="${param.page  }">
	<h6>삭제하시겠습니까?</h6>
	<div class="mb-3">
			<input type="password" class="form-control" id="r_pw" name="r_pw" size="10" maxlength="10" placeholder="비밀번호">
		</div>
		
		<hr class="mb-4">
			<div class="text-center">
				<button class="btn btn-light btn-sm" type=submit>삭제</button>
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
              <p>Copyright &copy;
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