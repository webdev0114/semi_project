<%@page import="java.util.ArrayList"%>
<%@page import="dao.R_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/view.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">

<script>
	$(document).ready(function(){
		$("form").submit(function(){
			if($("#re_comment").val()==""){
				alert("내용을 입력해 주세요.");
				$("#re_comment").focus();
				return false;
			}				
		});			
	});	
</script>

<title>Bon voyage</title>
</head>
  <body style="background-color: #f8f8f8">
	<nav class="navbar navbar-expand-lg navbar-light">
	  	<div class="container">
			    <a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a> 
			</div>
		</nav>
			
		<br><br><br>
<!-- 댓글 작성 폼 -->
<div class="container">
<form class="form-comment" action="<%=request.getContextPath()%>/RE_Update.re?" method="post"
					enctype="multipart/form-data">
<input type="hidden" name="id" value="${comment.id }">
<input type="hidden" name="re_num" value="${comment.re_num }">
<input type="hidden" name="r_num" value="${comment.r_num }">
<input type="hidden" name="page" value="${page}">
		<div class="text-left">
			<h4>댓글 수정</h4><br>
		</div>

			
				<div class="mb-3">
					<input type=text class="form-control" id="name" name="name" placeholder=${sessionScope.id } readonly>
				</div>
				
				<div class="mb-3">
					<textarea class="form-control" id="re_comment" name="re_comment"cols="67" rows="10"
					>${comment.re_comment}</textarea>
					<input class="form-control" name="re_file"type="file" value="src='./re_file/${comment.re_file}'">
					</div>
					<div class="text-left">
						<hr class="mb-4">
						<button class="btn btn-light btn-sm" type="submit">댓글 수정</button>
					</div>
				
		<br>
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
