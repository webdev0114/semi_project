<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/write.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">

	<title>Bon voyage</title>
</head>
  <body>
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
		
	<div class="container">
		<form class="form-signin" action="<%=request.getContextPath()%>/R_AddAction.r" method="post"
				enctype="multipart/form-data">
			
			<div class="text-left">
				<h2 class="section-title"> 후기 글쓰기</h2>
			</div>
			
			<div class="mb-3">
				<input type="text" class="form-control" name="id" id="id" placeholder="${id }" value="${id }" readonly>
			</div>

			<div class="mb-3">
				<input type="password" class="form-control" name="r_pw" id="r_pw" size="10" maxlength="10" 
					placeholder="비밀번호">
			</div>

			<div class="mb-3">
				<input type="text" class="form-control"  name="r_title" id="r_title" size="50" maxlength="100" 
					placeholder="제목">
			</div>

			<div class="mb-3">
				<textarea class="form-control" name="r_content" id="r_content" cols="67" rows="10"
					placeholder="후기글 소개"></textarea>
			</div>

			<div class="mb-3">
				<input class="form-control" type="file" name="r_file" id="r_file">
			</div>

			<hr class="mb-4">
			<div class="text-left">
				<button class="btn btn-light btn-sm" type="submit" value="등록">등록</button>
				<button class="btn btn-light btn-sm" type=button
					onClick="location.href='./R_ListAction.r'">목록</button>
			</div>
				</form>
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
	<script>
	$(document).ready(function(){
		$("form").submit(function(){
			if($("#r_pw").val()==""){
				alert("비밀번호를 입력해 주세요.");
				$("#r_pw").focus();
				return false;
			}
			if($("#r_title").val()==""){
				alert("제목을 입력해 주세요.");
				$("#r_title").focus();
				return false;
			}
			if($("#r_content").val()==""){
				alert("내용을 입력해 주세요.");
				$("#r_content").focus();
				return false;
			}				
		});			
	});	
	</script>
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