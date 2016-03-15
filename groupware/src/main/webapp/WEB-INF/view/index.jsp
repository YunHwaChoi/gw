<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>그룹웨어 시스템</title>
<link href="./css/index.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<div id="body">
		<div id="header">기업이 먼저다 - 도산중공업</div>
		<fieldset>
		<legend>로그인 정보</legend>
		<form id="form" action="index.do" method="post">
			<ul>
				<li><label for="id">사원번호(아이디)</label><input type="text" id="id" name="id" required="required"/></li>
				<li><label for="pw">비밀번호</label><input type="password" id="pw" name="pw" required="required"></li>
				<li><button>로그인</button></li>
			</ul>
		</form>
	</fieldset>
</div>
</body>
</html>