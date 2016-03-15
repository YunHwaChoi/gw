<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/anonymous/common.css" />
<link rel="stylesheet" type="text/css" href="../css/anonymous/list.css" />
<title>익명게시판</title>
</head>
<body>
	<table id="ano_tbl">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	<c:forEach var="anonymous" items="${list }">
		<tr>
			<td class="no">${anonymous.no }</td>
			<td class="title"><a href="view.do?no=${anonymous.no }&page=${jspData.page }" >
				${anonymous.title }<i class="fa fa-commenting-o replyIcon"></i>${anonymous.rcount }</a>
			</td>
			<td class="writer">${fn:substring(anonymous.writer, 0, 8)}</td>
			<td class="wdate">${anonymous.wdate }</td>
			<td class="hit">${anonymous.hit }</td>
		</tr>	
	</c:forEach>
	
	</table>
	
	<div class="bottom">
	
		<div class="leftBox">
			
		</div>
		
		<div class="rightBox">
			<a href="write.do"><button class="btn">글쓰기</button></a>
		</div>
		
		<c:if test="${!empty jspData }">
		
			<div class="pageBox">
				<a href="list.do?page=1"><i class="fa fa-step-backward"></i></a>
				<a href="list.do?page=${jspData.startPage > 1 ? jspData.startPage-jspData.pagesPerGroup : 1 }"><i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i></a>
				<a href="list.do?page=${jspData.page > 1 ? jspData.page-1 : 1 }"><i class="fa fa-chevron-left"></i></a>
			
				<c:forEach var="i" begin="${jspData.startPage }" end="${jspData.endPage }">
					<c:choose>
						<c:when test="${jspData.page eq i }">
							<span class="cpage">${i }</span>
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
		
		</c:if>
		
	</div>
	
</body>
</html>