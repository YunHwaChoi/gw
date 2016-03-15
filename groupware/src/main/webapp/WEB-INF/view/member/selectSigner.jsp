<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/member/selectSigner.css" />
<title>사원 목록</title>
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".signer").click(function() {
		var returnValue = {
			id: $(this).find(".id").text(),
			name: $(this).find(".name").text(),
		};
		window.opener.getReturnValue(returnValue);
		window.close();
	});
});
</script>
</head>
<body>
	<div class="body">
		<table class="selectSignerTbl">
			<tr>
				<th>사원ID</th>
				<th>이름</th>
				<th>소속 부서</th>
				<th>직위</th>
			</tr>
			<c:forEach var="member" items="${list }">
				<tr class="signer">
					<td class="id">${member.id }</td>
					<td class="name">${member.name }</td>
					<td class="dep">${member.dep }</td>
					<td class="position">${member.position }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>