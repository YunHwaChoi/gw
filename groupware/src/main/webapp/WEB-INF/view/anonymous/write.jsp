<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/anonymous/write.js"></script>
<link rel="stylesheet" type="text/css" href="../css/anonymous/common.css" />
<link rel="stylesheet" type="text/css" href="../css/anonymous/write.css" />
<title>익명게시판</title>
</head>
<body>
	<div class="body">
		<form action="write.do" method="post" id="form1">
			<label for="title">제목</label><input class="title" id="title" name="title">
			<div class="clear"></div>
			<label for="content"></label><textarea class="content" id="content" name="content"></textarea>
			<input type="hidden" name="writer" value="${login.encId }">
			<div class="btnDiv">
				<button type="button" class="btn btnCancel" onclick="history.back()">취소</button>
				<div class="nbsp">&nbsp;</div>
				<button class="btn btnSubmit">작성</button>
			</div>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>