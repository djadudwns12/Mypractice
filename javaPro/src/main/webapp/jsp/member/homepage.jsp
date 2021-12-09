<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
<style>
header {
	height: 53px;
}

.Left_side_bar {
	float: left;
}

.Right_side_bar {
	float: right;
	flex-direction: row;
}

.head_bar {
	display: flex;
	flex-direction: row;
	list-style: none;
}

li {
	margin-right: 10px;
}

.box_login {
	border: 1px solid black;
}

img {
	display: block;
	width: 1080px;
	max-height: 340px;
}

#cafe_body {
	width: 1080px;
	margin: auto;
}

.search {
	width: 1080px;
	height: 24px;
	margin-top: 10px;
	margin-bottom: 10px;
}

.search_body {
	float: right;
}

.section_left {
	width: fit-content;
	border: 2px solid black;
}

.space_line {
	border-bottom: 1px solid blue;
}

.top_margin {
	margin-top: 10px;
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

 <script>
     $(document).ready(function(){
    	  $("a").click(function(){
    	    $("[href]").load();
  });
});
</script>

</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div id="cafe_skin">
		<div id="cafe_body">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				<a class="navbar-brand" href="#">게시판 홈</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<c:choose>
							<c:when test="${empty SESS_LOGINFO}">
								<li class="nav-item"><a class="nav-link"
									href="<c:url value='/member/login.do'/>">로그인</a></li>
								<li class="nav-item"><a class="nav-link"
									href="<c:url value='/member/join_form.do'/>">회원가입</a></li>
							</c:when>
							<c:otherwise>
							<li class="nav-item"><a class="nav-link"
									href="<c:url value='/member/logout_action.do'/>">로그아웃</a></li>
							
							</c:otherwise>
							
						</c:choose>
						<li class="nav-item"><a class="nav-link" href="#">세션정보</a></li>
					</ul>
				</div>
			</nav>

			<div class="img_big" style="margin-top:10px">
				<img src="${contextPath}/resources/car_pic.jpg" alt="사진">
			</div>
			<div class="search">
				<div class="search_body">
					<input type="text"><input type="submit" value="검색">
				</div>
			</div>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
     
      <h3>게시판 메뉴</h3>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="${pageContext.request.contextPath}/board/board_write_form.do">게시글쓰기</a>
        </li>
        <li class="nav-item" >
          <a class="nav-link" id="allboard" href="${pageContext.request.contextPath}/member/login.do">전체글 보기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">공지사항</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
    <iframe src="${document}">
    ....
    </iframe>
    </div>
  </div>
</div>

<%-- <section>
				<div class="section_left">
					<div class="section_left_top">
						<a
							href="${pageContext.request.contextPath}/board/board_write_form.do">글쓰기</a>
					</div>
					<div class="space_line"></div>
					<div class="section_left_mid">
						<ul class="content_overview">
							<li><a href="#">전체글 목록</a></li>
						</ul>
						<div class="space_line"></div>
						<ul class="notice">
							<li><a href="#">공지사항</a></li>
						</ul>
						<div class="space_line"></div>
						<ul class="education">
							<학습>
							<li class="top_margin"><a href="#">JAVA</a></li>
							<li class="top_margin"><a href="#">HTML/CSS</a></li>
							<li class="top_margin"><a href="#">SQL</a></li>
							<li class="top_margin"><a href="#">JSP/Servlet</a></li>
							<li class="top_margin"><a href="#">Spring</a></li>
						</ul>
						<ul class="References">
							<참고자료>
							<li class="top_margin"><a href="#">JAVA</a></li>
							<li class="top_margin"><a href="#">HTML/CSS</a></li>
							<li class="top_margin"><a href="#">SQL</a></li>
							<li class="top_margin"><a href="#">JSP/Servlet</a></li>
							<li class="top_margin"><a href="#">Spring</a></li>
						</ul>
					</div>
					<div class="section_left_btm"></div>
				</div>



				<div class="section_right"></div>

			</section> --%>

			<footer> </footer>
		</div>
	</div>
</body>

</html>