<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

  <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/fonts/icomoon/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/fonts/flaticon/font/flaticon.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/aos.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/join.css">
  
<title>Bon voyage</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				document.getElementById('post').value = data.zonecode;
				document.getElementById('addr').value = data.address;
				
			}
		}).open();
	}
</script>
<script src="<%=request.getContextPath() %>/main/idcheck.js"></script>

</head>

<body class="text-center" style="background-color: #f8f8f8">
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a>

				  <ul class="navbar-nav ml-auto">
				  
				   <li class="nav-item">
						      <a class="nav-link" href="<%=request.getContextPath()%>/Logout.m">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
						  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
						  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
						</svg>
						<b>&nbsp;로그아웃</b></a>
				    </li>
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
	<br><br><h3 style="text-align: center"><b>회원정보 수정</b></h3>
</div>

	<div class="container">
		<div class="signin-container">
			<div class="card border-0 shadow rounded-3 my-5">
				<div class="card-body p-10 p-sm-5">
					<form method="post" action="<%=request.getContextPath() %>/Update.m">
						<div class="mb-3">
							<input type=text class="form-control" id="id" name="id" value="${member.id }" readonly>
						</div>
						<div class="mb-3">
							<input type=password class="form-control" id="pw" name="pw" placeholder="비밀번호">
						</div>
						<div class="mb-3">
							<input type=text class="form-control" id="name" name="name" placeholder="이름" value="${member.name }">
						</div>
						<div class="form-row">
							<div class="col-md-6 mb-1">
								<input type=text class="form-control" size=5 maxlength=6 value="${member.jumin1 }" readonly>
							</div>
							<div class="col-md-6 mb-1">
								<input type="text" class="form-control" size=7 maxlength=7 value="${member.jumin2 }" readonly>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-6 mb-1">
								<input type=text class="form-control" size=5 maxlength=10 id="mail" name="mail" placeholder="이메일" value="${member.mail }">
							</div>
	
							<div class="col-md-6 mb-1">
								<input type="text" class="form-control" size=7 maxlength=15 id="domain" name="domain" value="${member.domain }">
							</div>
						</div>

						<div class="form-row">
							<div class="col-md-4 mb-1">
								<input type=text class="form-control" size=4 maxlength=3 id="tel1" name="tel1" placeholder="연락처" value="${member.tel1 }">
							</div>

							<div class="col-md-4 mb-1">
								<input type=text class="form-control" size=4 maxlength=4 id="tel2" name="tel2" value="${member.tel2 }">
							</div>

							<div class="col-md-4 mb-1">
								<input type=text class="form-control" size=4 maxlength=4 id="tel3" name="tel3" value="${member.tel3 }">
							</div>
						</div>

						<div class="form-inline mb-3">
							<input type=text class="form-control" size=5 id="post" name="post" value="${member.post }">
							<div class="input-group-append"></div>&emsp;
							<button type="button" class="btn btn-light btn-sm" onclick="openDaumPostcode()">우편번호 찾기</button>
						</div>

						<div class="mb-3">
							<input type=text class="form-control" size=45 id="addr" name="addr" value="${member.addr }">
						</div>

						<hr class="mb-4">
						<button class="btn btn-light btn-sm btn-block" type="submit">회원정보 수정</button>
						<button class="btn btn-light btn-sm btn-block" type=button onclick="history.go(-1)">취소</button>
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
	<script src="<%=request.getContextPath()%>/main/js/owl.carousel.min.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/aos.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/imagesloaded.pkgd.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/jquery.animateNumber.min.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/jquery.waypoints.min.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/jquery.fancybox.min.js"></script>
	<script src="<%=request.getContextPath()%>/main/js/custom.js"></script>

</body>
</html>
  