<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="shortcut icon" type="image/x-icon" href="../favicon.png"> -->
<!-- <link rel="icon" type="image/x-icon" href="../favicon.png"> -->
<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
<link rel="stylesheet" type="text/css" href="/groupware/css/decorator.css">
<script src="/groupware/js/common/jquery-1.12.0.min.js"></script>
<title>그룹웨어 시스템</title>
<decorator:head />
</head>
<body>

<div id="wrapper">
	<div id="header">
		<div id="main_title">
			<a href="/groupware/main.do">그룹웨어 시스템</a>
		</div>
		<div id="nav">
			<ul>
				<li><a href="/groupware/draft/proceed/list.do">전자결재</a></li>
				<li><a href="/groupware/schedule/list.do">일정관리</a></li>
				<li><a href="/groupware/notice/list.do">커뮤니티</a></li>
				<li><a href="/groupware/message/list.do">마이페이지</a></li>
				<c:if test="${login.pno==9 }">
				<li><a href="/groupware/member/list.do">사원관리</a></li>
				</c:if>
			</ul>
		</div>
		<div id="status">
			이용자 : ${login.name }님&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/groupware/logout.do">로그아웃</a>
		</div>
	</div>
	
	<div id="side_left">
		<ul>
			<li class="li_title">커뮤니티</li>
			<li class="li_content"><a href="/groupware/notice/list.do">공지사항</a></li>
			<li class="li_content"><a href="/groupware/board/list.do">자유게시판</a></li>
			<li class="li_content"><a href="/groupware/data/list.do">자료실</a></li>
			<li class="li_content"><a href="/groupware/anonymous/list.do">익명게시판</a></li>
		</ul>
	</div>
	
	<div id="content_wrapper">
		<decorator:body />
	</div>
	
	<div id="footer">
		Copyright ⓒ ~~~~~
	</div>
</div>

</body>
</html>