<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정관리</title>
<link href="../css/schedule/view.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1></h1>
<br/>
<table class="table_view">
	<tr class="num">
		<th>등록일</th><td>${schedule.sdate }</td>
	</tr>
	<tr class="num">
		<th>등록시간</th><td>${schedule.time } 시</td>
	</tr>
	<tr class="num">
		<th>제 목</th><td>${schedule.title }</td>
	</tr>
	<tr class="num">
		<th>내 용</th><td class="cont"><div style="overflow-y:scroll; height:100%; width:100%">
		<pre id="cont_pre">${schedule.content }</pre></div></td>
	</tr>
</table>
	<div id="Btn">
			<a href="list.do"><button id="list_Btn">일정리스트</button></a>
			<a href="update.do?no=${schedule.no }"><button id="submit_Btn">일정수정</button></a>
			<a href="delete.do?no=${schedule.no }"><button id="cancer_Btn">일정삭제</button></a>
	</div>
</body>
</html>