<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.error {
	text-align: center;
}

.errorCode {
	font-size: 40pt;
	font-weight: bolder;
	color: red;
}

.errorMessage {
	font-size: 20pt;
}

.btn {
	display: block;
	font-size: 15pt;
	width: 100px;
	height: 33px;
	margin-top: 15px;
}
</style>
</head>
<body>
	<div class="error">
		<span class="errorCode">400 에러</span><br>
		<span class="errorMessage">관리자에게 문의하세요</span><br>
		<button class="btn" onclick="history.back()">뒤로가기</button>
	</div>
</body>
</html>