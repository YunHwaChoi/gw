<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../../css/message/list.css" rel="stylesheet" type="text/css" />

<title>보낸 쪽지 리스트</title>
<script type="text/javascript" src="../../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 체크박스 모두선택
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")){
				$("input[name=nos]").not(":disabled").prop("checked", true);
			}
			else {
				$("input[name=nos]").prop("checked", false);
			}
		});
		
		$("#listForm").submit(function(){
			if(confirm("정말 삭제하시겠습니까?")== false){
				return false; // 삭제 취소
			}
			});
		$("#listForm").submit(function(){
			if($("input:checkbox").is(":checked")== false){
				alert("선택된 글이 없습니다.")
				return false;
			}
		});
		
	});
</script>
</head>
<body id="messageBody">
	<form action="delete.do" method="post" id="listForm">
	
	<a href="../write.do"><button type="button" id="messageBtn">쪽지 작성</button></a>
	<button id="messageDeleteBtn">선택 쪽지 삭제</button>
	<br/><br/>
	
	<table id="messageTable">
		<tr id="messageTr">
			<th class="messageTh">글번호</th>
<!-- 			체크박스 모두선택 -->
			<th class="messageTh">
			<input type="checkbox" id="checkAll" value="모두선택" /><br/>
			</th>
			<th id="messageThTitle">제목</th>
			<th class="messageTh">받은사람</th>
			<th class="messageTh">보낸시간</th>			
			<th class="messageTh">확인시간</th>
		</tr>
		<!-- 	반복 시작 :  -->
		<c:forEach var="message" items="${list }">
		<tr id="messageTr">
			<td class="messageTd">${message.no }</td>
			
			<!-- 			 no가  forEach에 의해 여러개 생기므로 controller 에서 받을 때 check 한 값을 모드 받으려면 배열로 받는다. -->
			<td class="messageTd"><input type="checkbox" id="nos" name="nos" value="${message.no}" 
			<c:if test="${message.rdate ne null }">disabled="disabled"</c:if> /></td>
			
			<td id="messageTdTitle"><a href="view.do?no=${message.no }">${message.title }</a></td>
			<td class="messageTd">${message.name }</td>
			<td class="messageTd">${message.sdate }</td>
			<td class="messageTd">
			<c:if test="${message.rdate eq null}">미확인</c:if>
			<c:if test="${message.rdate ne null}">${message.rdate }</c:if>
			 </td>
		</tr>
		</c:forEach>
<!-- 			반복의 끝 -->

	</table>
	</form>
	
	<div id="pageMove">
		<a href="list.do?page=1"><i class="fa fa-step-backward"></i></a>
		<a href="list.do?page=${jspData.startPage > 1 ? jspData.startPage-jspData.pagesPerGroup : 1 }"><i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i></a>
		<a href="list.do?page=${jspData.page > 1 ? jspData.page-1 : 1 }"><i class="fa fa-chevron-left"></i></a>
	
		<c:forEach var="i" begin="${jspData.startPage }" end="${jspData.endPage }">
			<c:choose>
				<c:when test="${jspData.page eq i }">
					<span id="cpage">${i }</span>
				</c:when>
				<c:otherwise>
					<a href="list.do?page=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<a href="list.do?page=${jspData.totalPage > jspData.endPage ? jspData.page+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i></a>
		<a href="list.do?page=${jspData.totalPage > jspData.endPage ? jspData.endPage+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i></a>
		<a href="list.do?page=${jspData.totalPage }"><i class="fa fa-step-forward"></i></a>
	</div>
	
</body>
</html>