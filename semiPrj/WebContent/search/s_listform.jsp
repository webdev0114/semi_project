<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/list.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/main/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/search/search.css">
	
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
								</svg><b>로그아웃</b>
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
			<header class="back-header">
				<br><br><br><br><br><br><br><br><br><br><br><br><br>
			</header><br><br>
		</div>
		
<<c:set var="num" value="${listcount - (page-1) * 10 }" />
<div class="search-wrapper">
	<div class="container">
	       <div class="row gutter-v1 align-items-stretch">
	         <div class="col-12"><br>
				<h2 class="section-title">검색 결과 : </h2>  ${listcount}개 <br>
			<ul class="search-list">
			
		<c:set var="num" value="${startRow }"/>
		<c:forEach var="s" items="${boardlist }">
		<c:if test="${s.s_theme eq 'place' }">
			<li class="search-item">
				<div class="preview">
					<img title="리뷰 이미지" alt="리뷰 이미지" src="./p_file/${s.s_file}" 
						width="100" height="100">
				</div>
				
				&emsp;<div class="search-title contents">
				<div>작성자 : ${s.id}</div>
				<a href="./P_DetailAction.p?p_num=${s.s_num}&page=${page}">
					<div class="search-title">
						${num}.${s.s_name}
					</div>
				</a>
				<c:set var="num" value="${num+1}"/>
					<div class="search-content">&emsp;
						<span class="search"><textarea class="textbar" cols="100" rows="5" readonly>${s.s_content}</textarea></span>
					</div>
				</div>
				</li>
			<hr size="80px"><br>
			</c:if>
			<c:if test="${s.s_theme eq 'food' }">
			<li class="search-item">
				<div class="preview">
					<img title="리뷰 이미지" alt="리뷰 이미지" src="./p_file/${s.s_file}" 
						width="100" height="100">
				</div>
				
				&emsp;<div class="search-title contents">
				<div>작성자 : ${s.id}</div>
				<a href="./F_DetailAction.f?f_num=${s.s_num}&page=${page}">
					<div class="search-title">
						${num}.${s.s_name}
					</div>
				</a>
				<c:set var="num" value="${num+1}"/>
					<div class="search-content">&emsp;
						<span class="search"><textarea class="textbar" cols="100" rows="5" readonly>${s.s_content}</textarea></span>
					</div>
				</div>
				</li>
			<hr size="80px"><br>		
			</c:if>				
			</c:forEach>		
		</ul>
	</div>
		</div>
	</div>
</div>
<!-- 페이지 처리 -->
<c:if test="${listcount >0 }">
	<nav aria-label="Page navigation example">
	        <ul class="pagination justify-content-center">

<!-- 1페이지로 이동 -->
<li class="page-item">
	       <a class="page-link" href="./S_ListAction.s?page=1&sear=${sear}" style="text-decoration:none" tabindex="-1" aria-disabled="true"><<</a>
		</li>
<!-- 이전 블럭으로 이동 -->
<c:if test="${startPage > 10 }">
	<li class="page-link">
			<a href="./S_ListAction.s?page=${startPage-10 }&sear=${sear}">[이전]</a>
			</li>
</c:if>

<!-- 각 블럭에 10개 페이지 -->
<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<c:if test="${i == page }">
		<ul class="pagination justify-content-end">
		    	 <li class="page-item disabled"><a class="page-link" href="#">${i}</a></li>
		    	 </ul>
	</c:if>
	<c:if test="${i != page }">
		<li class="page-item">
			<a class="page-link" href="./S_ListAction.s?page=${i}&sear=${sear}">${i}</a>
				</li>
	</c:if>
</c:forEach>

<!-- 다음 페이지로 이동 -->
<c:if test="${endPage < pageCount }">
	<a href="./S_ListAction.s?page=${startPage+10 }&sear=${sear}">[다음]</a>
</c:if>

<!-- 마지막 페이지로 이동 -->
		<li class="page-item"> 
			<a class="page-link" href="./S_ListAction.s?page=${pageCount}&sear=${sear}" style="text-decoration:none">>></a>
			</li>
		</ul>
	</nav>
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
	    <script src="<%=request.getContextPath()%>/main/js/aos.js"></script>
	    <script src="<%=request.getContextPath()%>/main/js/imagesloaded.pkgd.js"></script>
	    <script src="<%=request.getContextPath()%>/main/js/isotope.pkgd.min.js"></script>
	    <script src="<%=request.getContextPath()%>/main/js/jquery.animateNumber.min.js"></script>
	    <script src="<%=request.getContextPath()%>/main/js/jquery.waypoints.min.js"></script>
	    <script src="<%=request.getContextPath()%>/main/js/custom.js"></script>
    
	</body>
</html>