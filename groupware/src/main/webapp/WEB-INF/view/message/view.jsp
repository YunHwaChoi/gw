<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/message/view.css" rel="stylesheet" type="text/css" />

<title>쪽지 보기</title>
</head>
<body id="messageBody">
	<!-- 		배열로 받기 위해 nos로 받음 -->
		<a id="messageBtnA" href="delete.do?nos=${message.no }&page=${page }"><button id="messageBtn">삭제</button></a>
		<a id="messageBtnA" href="list.do?no=${message.no }&page=${page }"><button id="messageBtn">쪽지 리스트</button></a> <br/><br/><br/>
		<c:if test="${message.fileName }"></c:if>
	
	<table id="messageTable">
		<tr class="messageTr">
			<th>글번호</th>
			<td>${message.no }</td>
		</tr>
		<tr class="messageTr">
			<th>제목</th>
			<td>${message.title}</td>
		</tr>
		<tr class="messageTr">
			<th>내용</th>
			<td><pre>${message.content }</pre></td>
		</tr>
		<tr class="messageTr">
			<th>보낸<br/>사람</th>
			<td>${message.name}</td>
		</tr>
		<!-- 		<tr> -->
		<!-- 			<th>받은사람</th> -->
		<%-- 			<input type="hidden" value="${message.receiver }"> --%>
		<%-- 			<td>${message.receiver}</td> --%>
		<!-- 		</tr> -->

		<!-- 		첨부파일이 없을 경우 숨김 -->
		<c:if test="${message.fileName ne null}">
		<tr class="messageTr">
				<th>첨부<br/>파일</th>
				<!-- 		target을 _blank로 지정해주면 새 창으로 뜬다. -->
				<td><a href="../upload/message/${message.fileName }"
					target="_blank">${message.fileName }</a>
			</tr>
		</c:if>
		<tr class="messageTr">
			<th>보낸<br/>시간</th>
			<td>${message.sdate}</td>
		</tr>
		<tr class="messageTr">
			<th>확인<br/>시간</th>
			<td>${message.rdate }</td>
		</tr>
	</table>
</body>
</html>