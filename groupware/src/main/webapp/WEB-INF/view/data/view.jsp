<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/data/view.css" rel="stylesheet" type="text/css" /> 

<title>Insert title here</title>
</head>
<body>
<!-- 	<h2>자료게시판 글보기</h2><br/><br/> -->
	<table id="table">
		<tr>
			<th>글번호</th><td> ${data.no }</td>
			<th>제목</th><td>${data.title}</td>
			<th>조회수</th><td>${data.hit }</td>
		</tr>	
			<tr>
			<th>작성자</th><td>${data.name }</td>
			</tr>
		<tr>
			<td colspan=6 id="tdLine"></td>
		</tr>
		<tr>
		</tr>
		<tr id="contentGap"></tr>
		<tr>
<!-- 			<th id="th5">내용</th> -->
			<td colspan=5><pre>${data.content}</pre></td>
		</tr>
		<tr id="fileGap"></tr>
		<tr>
			<th>첨부 파일</th>
				<c:if test="${data.fileName ne null }">
					<c:if test="${fn:toLowerCase(fn:substringAfter(data.fileName, '.')) eq 'png' ||
					fn:substringAfter(data.fileName, '.') eq 'jpg'||
					fn:substringAfter(data.fileName, '.') eq 'gif'||
					fn:substringAfter(data.fileName, '.') eq 'jpeg'}">
						<td><img alt="image" src="../upload/data/${data.fileName }">
					</c:if>
<!-- 					<td> -->
<%-- 						<a href="../upload/data/${data.fileName}" target="_blank">${data.fileName}</a> --%>
<!-- 					</td> -->
					
					<c:if test="${fn:toLowerCase(fn:substringAfter(data.fileName, '.')) eq 'pptx' ||
					fn:substringAfter(data.fileName, '.') eq 'doc'||
					fn:substringAfter(data.fileName, '.') eq 'hwp'||
					fn:substringAfter(data.fileName, '.') eq 'xlsx'}">
						<td>
						<a href="../upload/data/${data.fileName}" target="_blank">${data.fileName}</a>
					</td>
					</c:if>
					
				</c:if>
				
				
				<c:if test="${data.fileName eq null }">
					<td>
						첨부 파일 없음
					</td>
				</c:if>

		</tr>

	</table>
	
		<div id="btnDiv">
			<c:choose>
				<c:when test="${login.id eq data.writer }"><a href="delete.do?no=${data.no }"><button id="deleteBtn">글삭제</button></a></c:when>
				<c:when test="${login.pno==9}"><a href="delete.do?no=${data.no }"><button id="deleteBtn">글삭제</button></a></c:when>
			</c:choose>
			
			<c:if test="${login.id eq data.writer }">
			<a href="update.do?no=${data.no }"><button id="updateBtn">글수정</button></a>
			</c:if>
			
		
			
			<a href="list.do"><button id="listBtn">글리스트</button></a>
		</div>
</body>
</html>