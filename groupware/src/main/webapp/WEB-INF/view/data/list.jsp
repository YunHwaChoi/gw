<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/data/list.css" rel="stylesheet" type="text/css" /> 
<title>Insert title here</title>
</head>
<body>
<!-- 	<h2>자료실 리스트</h2><br/> -->
	<div id="searchDiv">
	<form action="list.do" method="post">
		<select name="option">
			<option>제목</option>
			<option>내용</option>
			<option>제목+내용</option>
			<option>작성자</option>
		</select>
		<input type="text" name="searchStr">
		<button>검색</button><br/><br/>
	</form>
	</div>
	
	<table id="table">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr id="attrGap"></tr>
		
<!-- 		반복의 시작 -->
	<c:forEach var="data" items="${list }">
		<tr>
			<td id="td1">${data.no }</td>
			<td id="td2"><a href="view.do?no=${data.no}">${data. title}</a></td>
			<td id="td3">${data.name }</td>
			<td id="td4">${data.wdate }</td>
			<td id="td5">${data.hit }</td>
		</tr>
	</c:forEach>
<!-- 	반복의 끝 -->
	</table>
	<table id="table2">
		<tr id="trBtn">
			<td colspan=4></td>
			<td></td>
			<td><a href="write.do"><button id="writeBtn">글쓰기</button></a></td>
			<td></td>
		</tr>
	</table>

		
		<div id="pageMove">
		<a href="list.do?page=1"><i class="fa fa-step-backward"></i></a>
		<a href="list.do?page=${jspData.startPage > 1 ? jspData.startPage-jspData.pagesPerGroup : 1 }"><i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i></a>
		<a href="list.do?page=${jspData.page > 1 ? jspData.page-1 : 1 }"><i class="fa fa-chevron-left"></i></a>
	
		<c:forEach var="i" begin="${jspData.startPage }" end="${jspData.endPage }">
			<c:choose>
				<c:when test="${jspData.page eq i }">
					<span id="cpage">${i }</span>
				</c:when>
				<c:otherwise>
					<a href="list.do?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<a href="list.do?page=${jspData.totalPage > jspData.endPage ? jspData.page+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i></a>
		<a href="list.do?page=${jspData.totalPage > jspData.endPage ? jspData.endPage+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i></a>
		<a href="list.do?page=${jspData.totalPage }"><i class="fa fa-step-forward"></i></a>
	</div>
	
</body>
</html>