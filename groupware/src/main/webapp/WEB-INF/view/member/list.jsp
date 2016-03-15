<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/member/list.css" rel="stylesheet" type="text/css" /> 
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <h2>사원 리스트</h2><br/><br/> -->

	<div id="searchDiv">
		<form action="list.do" method="post">
			<select name="option">
				<option>이름</option>
				<option>이름+소속부서</option>
			</select>
			<input type="text" name="searchStr">
			<button>검색</button>
		</form>
	</div>
	

	<table id="table">
	
		<tr>
			<th>사원ID</th>
			<th>이름</th>
			<th>소속 부서</th>
			<th>직위</th>
		</tr>
		<tr id="attrGap"></tr>
		
<!-- 		반복 시작 -->
	<c:forEach var="member" items="${list }">
		<tr>
			<td><a href="view.do?id=${member.id }">${member.id }</a></td>
			<td>${member.name }</td>
			<td>${member.dep }</td>
			<td>${member.position }</td>
		</tr>
	</c:forEach>
	</table>
	
<!-- 	페이지 처리 -->
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