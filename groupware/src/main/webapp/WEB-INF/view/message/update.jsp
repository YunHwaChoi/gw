<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 읽음 확인</title>
</head>
<body>
<form action="update.do" method="post">
	<input type="hidden" name="no" value="${message.no }" />
	<label for="rdate">읽음확인</label><input type="button" name="rdate" id="rdate" value="${message.rdate}"/><br/>
</form>
</body>
</html>