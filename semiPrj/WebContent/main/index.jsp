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

  <title>Bon voyage</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light">
	  	<div class="container">
	      <c:choose>
	      	  <c:when test="${empty sessionScope.id }">
					<a class="navbar-brand" href="<%=request.getContextPath()%>/main/index.jsp">Bon voyage</a>
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link" href="<%=request.getContextPath()%>/loginform.m">
									<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">
										<path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"></path>
										<path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"></path>
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
				              <li class="nav-item">
				              	<a class="nav-link" href="<%=request.getContextPath()%>/Q_ListAction.q">
				              	<svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
								  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"></path>
								</svg>
				              	<b>고객센터</b>
				              	</a>
			              	</li>
			            </ul>
          </c:when>
          <c:when test="${!empty sessionScope.id }">
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
				<li class="nav-item">
	              	<a class="nav-link" href="<%=request.getContextPath()%>/Q_ListAction.q">
	              	<svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"></path>
					</svg>
	              	<b>고객센터</b>
	              	</a>
              	</li>
            </ul>
	</c:when>
</c:choose>
		</div>
	</nav>
      
<div class="container">
	<header class="back-header">
		<br><br><br><br><br>
		<form class="search search-form" action="<%=request.getContextPath() %>/S_ListAction.s" method="post" id="submitform">
			<div class="search-inner rouned-pill">
				<input type="text" class="search-input" id="sear" name="sear" placeholder="검색">
					<a href="#" onclick="document.getElementById('submitform').submit();"><i class="fas fa-search"></i></a>
						</div>
		</form>	
		<br><br><br><br><br><br><br><br>
	</header><br><br>
</div><br>

      <div class="container">
        <div class="row gutter-v1 align-items-stretch mb-5">
          <div class="col-12">
            <h2 class="section-title">후기</h2><a class="module_more" href="<%=request.getContextPath()%>/R_ListAction.r" onclick="trackEvent('CLICK_TOPLIST_LIST')"><ins>리스트 더보기</ins></a>
          </div>
          <div class="col-md-9 pr-md-5">
            <div class="row">
              <div class="col-12">
                <div class="post-entry horizontal d-md-flex">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=360&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/forest01.jpeg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="#">여행</a></div>
                    <h2><a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=360&page=1">일산 포레스트 아웃팅스</a></h2>
                    <span>2022-04-15</span>
                    <p>간만에 운전도 할 겸, 여유있게 브런치도 먹을 겸 찾은 일산 브런치 카페 포레스트 아웃팅스. 송도가 본점.</p>
                  </div>
                </div>
              </div>

              <div class="col-12">
                <div class="post-entry horizontal d-md-flex">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=359&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/bluebottle02.jpeg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="#">여행</a></div>
                    <h2><a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=359&page=1">삼청동 블루보틀</a></h2>
                    <div class="meta mb-0">
                    <span>2022-04-15</span>
                    <p>오랜만에 삼청동 나들이를 나갔다. 그러다가 발견한 곳은 블루보틀</p>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-12">
                <div class="post-entry horizontal d-md-flex">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=358&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/ilsan01.jpeg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="#">맛집</a></div>
                    <h2><a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=358&page=1">일산칼국수 본점</a></h2>
                    <div class="meta mb-0">
	                    <span>2022-04-15</span>
	                    <p>일산에 오면 꼭 들르는 곳 중 한 집!! 아삭아삭 맵싹한 김치와 진한 닭칼국수 조합이 끝장나는 일산 칼국수 본점을 소개해드리려고 해요.</p>
                    </div>
                  </div>
                </div>
              </div>
              
              <div class="col-12">
                <div class="post-entry horizontal d-md-flex">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=357&page=1"><img src="<%=request.getContextPath()%>/main/images/joongang.jpeg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="#">여행</a></div>
                    <h2><a href="<%=request.getContextPath()%>/R_DetailAction.r?r_num=357&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">매콤달콤한 닭강정 먹고 즐기는 노을 - 중앙시장 만석꾼닭강정</a></h2>
                    <div class="meta mb-0">
	                    <span>2022-04-15</span>
	                    <p>강릉의 중심부에 자리하고 있는 중앙시장이다. 방송을 통해서도 익히 잘 알려진 중앙시장의 인기 아이템은 바로 매콤달콤한 닭강정.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>


          <div class="col-lg-6">
            <div class="row">
              <div class="col-12">
                <br>
                <h2 class="section-title">여행</h2><a class="module_more" href="<%=request.getContextPath()%>/P_ListAction.p" onclick="trackEvent('CLICK_TOPLIST_LIST')"><ins>리스트 더보기</ins></a>
              	</div>
              <div class="col-md-6 col-lg-6">
                <div class="post-entry">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/P_DetailAction.p?p_num=161&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/seongsanilchulbong.jpg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="<%=request.getContextPath()%>/P_DetailAction.p?p_num=161&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">제주 성산 일출봉</a></div>
                    <h2><a href="place.html">여행 정보</a></h2>
                    <div class="meta">
                      <p>일출봉의 전체 모습을 담으려면 산양해변에서 촬영하는 것이 가장 좋다.</p>
                    </div>
                  </div>
                  <div class="author d-flex align-items-center">
                    <div class="img mr-3">
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-6">
                <div class="post-entry">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/P_DetailAction.p?p_num=160&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/chinatown.jpg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="<%=request.getContextPath()%>/P_DetailAction.p?p_num=160&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">인천 차이나타운</a></div>
                    <h2><a href="<%=request.getContextPath()%>P_DetailAction.p?p_num=160&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">여행 추천 정보</a></h2>
                    <div class="meta">
                      <p>차이나타운의 주요 먹거리 역시 짜장면이다.</p>
                    </div>
                    <div class="author d-flex align-items-center">
                      <div class="img mr-3">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="row">
              <div class="col-12">
                <br>
                <h2 class="section-title">맛집</h2><a class="module_more" href="<%=request.getContextPath()%>/F_ListAction.f" onclick="trackEvent('CLICK_TOPLIST_LIST')"><ins>리스트 더보기</ins></a>
              </div>
              <div class="col-md-6 col-lg-6">
                <div class="post-entry">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/F_DetailAction.f?f_num=88&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/sinsapub.jpg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="<%=request.getContextPath()%>/F_DetailAction.f?f_num=88&page=1">이수_신사펍</a></div>
                    <h2><a href="food.html">맛집 추천 정보</a></h2>
                    <div class="meta">
                      <p>이수에서 따뜻한 감성을 느끼고 싶다면 신사펍으로 가보자.</pn>
                    </div>
                  </div>
                  <div class="author d-flex align-items-center">
                    <div class="img mr-3">
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-6">
                <div class="post-entry">
                  <div class="media">
                    <a href="<%=request.getContextPath()%>/F_DetailAction.f?f_num=87&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')"><img src="<%=request.getContextPath()%>/main/images/bamgasiburger.jpg" alt="Image" class="img-fluid"></a>
                  </div>
                  <div class="text">
                    <div class="meta-cat"><a href="<%=request.getContextPath()%>/F_ListAction.f?f_num=87&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">일산_밤가시버거</a></div>
                    <h2><a href="<%=request.getContextPath()%>/F_DetailAction.f?f_num=87&page=1" onclick="trackEvent('CLICK_TOPLIST_LIST')">맛집 추천 정보</a></h2>
                    <div class="meta">
                      <p>가게의 기본 메뉴인 오리지널 버거와 그 외로는 쉬림프 버거가 인기가 많다.</p>
                    </div>
                    <div class="author d-flex align-items-center">
                      <div class="img mr-3">
                      </div>
                    </div>
					</div>
						</div>
					</div>
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
                <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by <a href="https://untree.co" target="_blank" rel="nofollow noopener">Untree.co</a> &bullet; <a href="https://untree.co/license" target="_blank" rel="nofollow noopener">License</a>
                </p>
            </div>
            	</div>
			</div>
		</div>
	</div>

    <div id="overlayer"></div>
    <div class="loader">
      <div class="spinner-border" role="status">
        <span class="sr-only">Loading...</span>
      </div>
    </div>
    
    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
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