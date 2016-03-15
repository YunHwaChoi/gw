<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/mypage/view.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<!-- 	<h2>내 정보 보기</h2> -->
	<table id="table">
		<tr>
			<th>사원ID</th>
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>소속 부서</th>
			<td>${member.dep}</td>
		</tr>
		<tr>
			<th>직위</th>
			<td>${member.position}</td>
		</tr>
		<tr>
			<th>매니저</th>
			<td>${member.manager}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.tel}</td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td>${member.phone}</td>
		</tr>

	</table>
	
	<div id="btnDiv">
	<a href="pwupdate.do?id=${member.id }"><button id="btn">비밀번호 변경</button></a>
	</div>
		
</body>
</html>