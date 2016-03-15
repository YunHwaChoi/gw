<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../css/draft/common.css" />
<link rel="stylesheet" type="text/css" href="../../css/draft/list.css" />
<title>전자결재</title>
</head>
<body>
	<table id="draft_tbl">
		<tr>
			<th>번호</th>
			<th>기안자</th>
			<th>제목</th>
			<th>기안일자</th>
			<th>결재일자</th>
		</tr>
		
		<c:forEach var="draft" items="${list }">
			<tr>
				<td class="no">${draft.no }</td>
				<td class="drafter">${draft.drafter }</td>
				<td class="title"><a href="view.do?no=${draft.no}&page=${jspData.page }" >${draft.title }</a></td>
				<td class="regdate">${draft.regDate }</td>
				<c:choose>
					<c:when test="${draft.isSign3 eq null }">
						<td class="signdate">미결재</td>
					</c:when>
					<c:otherwise>
						<td class="signdate">${draft.isSign3 }</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		
	</table>
	
	<div class="bottom">
	
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
	
	</div>
</body>
</html>