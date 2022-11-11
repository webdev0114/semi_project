m<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<div class="container">
	<form class="form-comment" action="./RE_Recomment.re?" method="post" enctype="multipart/form-data">
		<div class="text-left">
			<br><h4>댓글 남기기</h4><br>
		</div>
		
		<input type="hidden" name="id" id="id" value="${sessionScope.id}"/>
		<input type="hidden" name="re_num" value="${comment.re_num}"/>
		<input type="hidden" name="r_num" value="${comment.r_num}"/>
		<input type="hidden" name="page"  value="${page}"/>
		<input type="hidden" name="comment_re_ref" value="${comment.re_re_ref }">
		<input type="hidden" name="comment_re_lev" value="${comment.re_re_lev }">
		<input type="hidden" name="comment_re_seq" value="${comment.re_re_seq }">
			
				<div class="mb-3">
					<input type=text class="form-control" id="name" name="name" placeholder=${sessionScope.id } readonly>
				</div>
				
				<div class="mb-3">
					<textarea class="form-control" id="re_comment" name="re_comment"cols="67" rows="10"
						placeholder="상대방을 존중하는 댓글을 남깁시다." ></textarea>
				<input class="form-control" name="re_file"type="file">
				</div>
					<div class="text-left">
						<hr class="mb-4">
						<button class="btn btn-light btn-sm" type="submit">댓글 작성</button>
					</div>
				
		</form><br>
	</div>
<br><br>	


</body>
</html>