<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/notice/view.css" rel="stylesheet" type="text/css" />

<title>공지사항 글보기</title>

</head>
<body id="noticeBody">
<!-- 			본인만 글수정, 글삭제 가능 -->
		<c:choose>
		<c:when test="${notice.writer eq login.id}">
			<a id="noticeBtnA" href="update.do?no=${notice.no }&page=${page }"><button id="noticeBtn">글수정</button></a>
			<a id="noticeBtnA" href="delete.do?nos=${notice.no }&page=${page }"><button id="noticeBtn">글삭제</button></a> 
		</c:when>
		<c:when test="${login.pno==9}">
			<a id="noticeBtnA" href="delete.do?nos=${notice.no }&page=${page }"><button id="noticeBtn">글삭제</button></a> 
		</c:when>
		</c:choose>
			<a  id="noticeBtnA" href="list.do?page=${page }"><button id="noticeBtn">공지사항 리스트</button></a><br/><br/><br/>
	<table id="noticeTable">
		<tr class="noticeTr">
			<th>글번호</th>
			<td>${notice.no }</td>
		</tr>
		<tr class="noticeTr">
			<th>제목</th>
			<td>${notice.title}</td>
		</tr>
		<tr class="noticeTr">
			<th>내용</th>
			<td><pre>${notice.content }</pre></td>
		</tr>
		<tr class="noticeTr">
			<th>작성자</th>
			<td>${notice.name }</td>
		</tr>
		<tr class="noticeTr">
			<th>작성일</th>
			<td>${notice.wdate }</td>
		</tr>
		<tr class="noticeTr">
			<th>조회수</th>
			<td>${notice.hit }</td>
		</tr>
<!-- 		첨부파일 없을 경우 숨김 -->
		<c:if test="${notice.fileName ne null }">
		<tr class="noticeTr">
			<th>업로드<br/>파일</th>
			<!-- 		target을 _blank로 지정해주면 새 창으로 뜬다. -->
			<td><a href="../upload/notice/${notice.fileName}"
				target="_blank">${notice.fileName}</a></td>
		</tr>
		</c:if>

	</table>
</body>
</html>