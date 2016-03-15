<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
<link href="../css/board/view.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1></h1>
<br/>
<table class="table_view">
	<tr class="num">
		<th>글번호</th><td>${board.no }</td>
	</tr>
	<tr class="num">
		<th>제 목</th><td>${board.title }</td>
	</tr>
	<tr class="num">
		<th>내 용</th><td class="cont"><div style="overflow-y:scroll; height:100%; width:100%">
		<pre id="cont_pre">${board.content }</pre></div></td>
	</tr>
	<tr class="num">
		<th>작성자</th><td>${board.name }</td>
	</tr>
	<tr class="num">
		<th>조회수</th><td>${board.hit }</td>
	</tr>
</table>
<div id="Btn">
		<a href="list.do"><button id="list_Btn">글리스트</button></a>
	<c:if test="${board.writer eq login.id }">
		<a href="update.do?no=${board.no }"><button id="submit_Btn">글수정</button></a>
		<a href="delete.do?no=${board.no }"><button id="cancer_Btn">글삭제</button></a>
	</c:if>
</div>
</body>
</html>