<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../css/message/view.css" rel="stylesheet" type="text/css" />

<title>쪽지 보기</title>
</head>
<body id="messageBody">
<!-- 		데이터가 있으면 삭제 버튼 생성, 없으면 감춤 -->
		<c:if test="${message.rdate eq null }">
<!-- 		배열로 받기 위해 nos로 받음 -->
		<a id="messageBtnA" href="delete.do?nos=${message.no }"><button id="messageBtn">삭제</button></a>
		</c:if>		
		<a id="messageBtnA" href="list.do?no=${message.no }"><button id="messageBtn">쪽지 리스트</button></a><br/><br/>
	
	<table id="messageTable">
		<tr class="messageTr">
		<th>글번호</th><td>${message.no }</td>
	</tr>
		<tr class="messageTr">
		<th>제목</th><td>${message.title}</td>
	</tr>
		<tr class="messageTr">
		<th>내용</th><td><pre>${message.content }</pre></td>
	</tr>
		<tr class="messageTr">
		<th>받은<br/>사람</th><td>${message.name}</td>
	</tr>
<!-- 	첨부파일이 없을 경우 숨김 -->
	<c:if test="${message.fileName ne null }">
		<tr class="messageTr">
		<th>첨부<br/>파일</th>
		<td><a href="../../upload/message/${message.fileName }"
			target="_blank">${message.fileName }
		</a></td>
	</c:if>
		<tr class="messageTr">
		<th>보낸<br/>시간</th><td>${message.sdate}</td>
	</tr>
		<tr class="messageTr">
		<c:if test="${message.rdate ne null}">
		<th>확인<br/>시간</th><td>${message.rdate }</td>
		</c:if>
	</tr>

</table>


</body>
</html>