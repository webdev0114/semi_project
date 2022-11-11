<%@page import="java.util.ArrayList"%>
<%@page import="dao.R_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
  <script src="http://code.jquery.com/jquery-latest.js"></script>
	
<script>
	$(document).ready(function(){
		$("form").submit(function(){
			if($("#re_comment").val()=="" && $("#re_file").val()==""){
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
					<c:if test="${empty sessionScope.id}">     
				      	<ul class="navbar-nav ml-auto">
							<li class="nav-item">
								<a class="nav-link" href="<%=request.getContextPath()%>/loginform.m">
									<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">
									  <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>
									  <path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
									</svg><b>로그인</b>
								</a>
			    			</li>
			    			
						    <li class="nav-item">
								      <a class="nav-link" href="<%=request.getContextPath()%>/joinform.m">
								<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
								  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
								</svg><b>회원가입</b>
								</a>
						    </li>
				    	</ul>
					</c:if>
				    
				    <c:if test="${!empty sessionScope.id}">     
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
				    </c:if>
			    </div>
			</nav>

		<div class="container">
	        <div class="row gutter-v1 align-items-stretch mb-5">
				<div class="col-12"><br><br><br>
					<div class="text-right">
						<c:if test="${sessionScope.id == review.id}">
						<button class="btn btn-default btn-sm" type=button
							onClick="location.href='./R_ModifyAction.r?r_num=${review.r_num}&page=${page}'">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"></path>
							</svg>&nbsp;수정</button>
						<button class="btn btn-default btn-sm" type=button
							onClick="location.href='./R_DeleteAction.r?r_num=${review.r_num}&page=${page}'">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
							  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"></path>
							</svg>&nbsp;삭제</button>
					</c:if>
							<button class="btn btn-default btn-sm" type=button 
								onClick="location.href='./R_ListAction.r?page=${page}'">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
								  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"></path>
								</svg>&nbsp;목록</button>
					</div>
				
	          		<hr class="mb-4">
	          		
	          		<div class="mb-3 text-left">
						<h2>${review.r_title}</h2>
					</div>
					
					<div class="mb-3 text-left" >
	          			작성자 : &nbsp;${review.id}
					<div class="text-left">
						${review.r_reg}
					</div>
					</div>
						
					<hr class="mb-4">
          			<div class="mb-3 text-left">
          			
						<c:if test="${review.r_file != null}">
							<img src="./r_file/${review.r_file}">
						</c:if>
					</div>
					<div class="mb-3 text-left">
						${content}
					</div>
			<c:if test="${review.r_file != null}">
			</c:if>
			
				<hr class="mb-4">
		
			</div>
		</div>
	</div>
	
	<!-- 댓글 작성 폼 -->
<c:if test="${!empty sessionScope.id && sessionScope.seller == 'normal'}">
<div class="container">
	<form class="form-comment" action="./RE_AddAction.re" method="post" enctype="multipart/form-data">
		<div class="text-left">
			<h4>댓글 남기기</h4><br>
		</div>
		
			<input type="hidden" name="id" id="id" value="${sessionScope.id}"/>
			<input type="hidden" name="r_num" value="${review.r_num}"/>
			<input type="hidden" name="page"  value="${page}"/>
			
			
				<div class="mb-3">
					<input type=text class="form-control" id="name" name="name" placeholder=${sessionScope.id } readonly>
				</div>
				
				<div class="mb-3">
					<textarea class="form-control" id="re_comment" name="re_comment"cols="67" rows="10"
						placeholder="상대방을 존중하는 댓글을 남깁시다." ></textarea>
				<input class="form-control" id="re_file" name="re_file"type="file">
				</div>
					<div class="text-left">
						<button class="btn btn-light btn-sm" type="submit">댓글 작성</button>
						<hr class="mb-4">
					</div>
				
		</form><br>
	</div><br><br>
</c:if>
	

<%-- <c:if test="${!empty relistcount =' }" > --%>
<!-- 댓글 리스트 -->
<c:if test="${relistcount != 0 }">
<div class="container">
<h3>댓글 리스트(${relistcount})</h3> 
<br>
<br>
<c:forEach var="comment" items="${re_list}">

<div class="form-comment">
	<div class="text-left">
				
                <h4>
                <c:if test="${comment.re_re_lev > 0 && comment.re_re_lev < 2}">
				└&nbsp;
				</c:if>
				 <c:if test="${comment.re_re_lev > 1 && comment.re_re_lev < 3}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└&nbsp;
				</c:if>
                작성자 ${comment.id }</h4>
                <p>
                 <c:if test="${comment.re_re_lev > 0 && comment.re_re_lev < 2}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				  <c:if test="${comment.re_re_lev > 1 && comment.re_re_lev < 3}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<fmt:formatDate value="${comment.re_reg}" pattern="yyyy-MM-dd HH:mm:ss EEE요일"/>
				</p>
                <p> <c:if test="${comment.re_re_lev > 0 && comment.re_re_lev < 2}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				 <c:if test="${comment.re_re_lev > 1 && comment.re_re_lev < 3}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>${comment.re_comment}</p>
                	<c:if test="${comment.re_file != null}">
                	<c:if test="${comment.re_re_lev > 0 && comment.re_re_lev < 2}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					 <c:if test="${comment.re_re_lev > 1 && comment.re_re_lev < 3}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${comment.re_comment != '삭제된 댓글입니다.' && comment.re_comment != 'null' }">
				<img title="이미지" src="./re_file/${comment.re_file}"  width="100" height="100"><br>
				</c:if>	
				</c:if>
   	</div>
   	<br>
   	
   	<div class="text-right">
   	<c:if test="${!empty sessionScope.id }">	
   	<c:if test="${comment.re_comment != '삭제된 댓글입니다.' && comment.re_comment != 'null' }">
   		 <c:if test="${comment.re_re_lev < 2 }">
   		<button class="btn btn-light btn-sm" type="button" 
			onClick="location.href='./RE_RecommentAction.re?r_num=${review.r_num}&page=${page}&re_num=${comment.re_num}&id=${sessionScope.id}'">댓글</button>
		</c:if>
	</c:if>
	<c:if test="${sessionScope.id == comment.id }">	
		<button class="btn btn-light btn-sm" type="button" 
			onClick="location.href='./RE_UpdateAction.re?r_num=${review.r_num}&page=${page}&re_num=${comment.re_num}&id=${sessionScope.id}&re_comment=${comment.re_comment }'">수정</button>
		<button class="btn btn-light btn-sm" type="button" 
			onClick="location.href='./RE_Delete.re?r_num=${review.r_num}&page=${page}&re_num=${comment.re_num}&id=${sessionScope.id}'">삭제</button>
	</c:if>
	</c:if>
	</div><br>
	
    
<hr class="mb-4">

</div>
</c:forEach>

</div>
</c:if>


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
