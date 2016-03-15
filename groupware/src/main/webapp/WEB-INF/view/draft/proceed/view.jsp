<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script type="text/javascript" src="../../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../../js/draft/view.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/draft/common.css" />
<link rel="stylesheet" type="text/css" href="../../css/draft/view.css" />
<title>전자결재</title>
</head>
<body>

	<div class="body">
		<div class="content">
			${draft.content }
		</div>
		
		<input type="hidden" id="no" value="${draft.no }">
		<input type="hidden" id="title" value="${draft.title }">
		<input type="hidden" id="drafter" value="${draft.drafter }">
		<input type="hidden" id="signer1" value="${draft.signer1 }">
		<input type="hidden" id="signer2" value="${draft.signer2 }">
		<input type="hidden" id="signer3" value="${draft.signer3 }">
		<input type="hidden" id="isSign1" value="${draft.isSign1 }">
		<input type="hidden" id="isSign2" value="${draft.isSign2 }">
		<input type="hidden" id="isSign3" value="${draft.isSign3 }">
		<input type="hidden" id="regDate" value="${draft.regDate }">
		<input type="hidden" id="name" value="${login.name }">
		
	</div>
	
	<div id="sign">
		<c:choose>
			<c:when test="${( login.id eq draft.signer1 ) ||
							( (login.id eq draft.signer2) && (!empty draft.isSign2) ) ||
							( (login.id eq draft.signer3) && (!empty draft.isSign3) ) }" />
			<c:otherwise>
				<form action="sign.do" method="post">
					<input type="hidden" name="no" value="${draft.no }">
					<input type="hidden" name="drafter" value="${login.id }">
					<input type="hidden" name="signer2" value="${draft.signer2 }">
					<input type="hidden" name="signer3" value="${draft.signer3 }">
					<button class="btn">결재</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>

	