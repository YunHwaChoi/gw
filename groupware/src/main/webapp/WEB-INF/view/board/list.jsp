<%@page import="com.dk.groupware.board.model.BoardModel"%>
<%@page import="com.dk.groupware.board.service.BoardListService"%>
<%@page import="com.dk.groupware.common.ServiceInterface"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/board/list.css" rel="stylesheet" type="text/css" />
<title>자유게시판</title>
</head>
<body>
<h1></h1>
<br/>
<table class="table_list">
	<thead>
	<tr>
		<th>글번호</th>
		<th>제  목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	</thead>
<!-- 	반복의 시작 -->
	<tbody>
	<c:forEach var="board" items="${list }">
		<tr>
			<td class="num">${board.no }</td>
			<td class="title"><a href="view.do?no=${board.no }">${board.title }</a></td>
			<td class="num">${board.name }</td>
			<td class="num">${board.wdate }</td>
			<td class="num">${board.hit }</td>
		</tr>
	</c:forEach>
	</tbody>
<!-- 	반복의 끝 -->
</table>
<div id="Btn">
	<a href="list.do"><button id="list_Btn">목록</button></a>
	<a href="write.do"><button id="submit_Btn">글쓰기</button></a>
</div>
<!-- 페이지 처리 = 반복문 처리 -->
<div id="boardPage">
	<a href="list.do?page=1"><i class="fa fa-step-backward"></i></a>
	<a href="list.do?page=${jspData.startPage>1?jspData.startPage-jspData.pagesPerGroup:1 }"><i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i></a> 
	<a href="list.do?page=${jspData.page>1?jspData.page-1:1 }"><i class="fa fa-chevron-left"></i></a>
		<c:forEach var="i" begin="${jspData.startPage }" end="${jspData.endPage }">
			<a href="list.do?page=${i }">${i }</a>
		</c:forEach>
	<a href="list.do?page=${jspData.totalPage>jspData.endPage?jspData.page+1:jspData.totalPage }"><i class="fa fa-chevron-right"></i></a> 
	<a href="list.do?page=${jspData.totalPage>jspData.endPage?jspData.endPage+1:jspData.totalPage }"><i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i></a> 
	<a href="list.do?page=${jspData.totalPage }"><i class="fa fa-step-forward"></i></a>
	<br/>

<form action="list.do" method="post">
	<select name="option">
		<option>제목</option>
		<option>내용</option>
		<option>제목+내용</option>
		<option>작성자</option>
	</select>
	<input type="text" name="searchStr">
	<button>검색</button><br/>
</form>
</div>
</body>
</html>