<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/mypage/pwupdate.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../js/common/util.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
// 		alert("test");
		$("#form").submit(function(){
			// 새 비밀번호와 새 비밀번호 확인을 비교하기
			if($("#new1").val() != $("#new2").val()){
				alert("새 비밀번호와 새 비밀번호 확인이 일치해야 합니다.");
			// 새 비밀번호와 새 비밀번호 확인 칸 비우기
			$("#new1").val("");
			$("#new2").val("");
			// 커서를 '새 비밀번호'창에 위치 시킨다
			$("#new1").focus();
			// submit 취소
			return false;
			};
			
	        // 기존 비밀번호와 새 비밀번호 일치 여부
// 	        if ($("#current").val() == $("#new1").val()) {
// 	            alert("기존 비밀번호와 새 비밀번호가 일치합니다.");
// 	            return false;
// 	        };
		});
	
	});

</script>
</head>
<body>
<div id="updateDiv">
<!-- <h2>내 비밀번호 수정</h2> -->
	<div id="formDiv">
	<form id="form" action="pwupdate.do" method="post" id="changePw">
			<table>
<!-- 				<tr> -->
<!-- 					<td><label for="current">기존 비밀번호</label></td> -->
<!-- 					<td><input type="password" id="current" name="current" placeholder="기존 비밀번호 입력"/></td> -->
<!-- 				</tr> -->
				
				<tr>
					<td><label for="new1">새 비밀번호</label></td>
					<td><input type="password" id="new1" name="pw" placeholder="새 비밀번호 입력"/></td>
				</tr>
				
				<tr>
					<td><label for="new2">새 비밀번호 확인</label></td>
					<td><input type="password" id="new2" placeholder="새 비밀번호 확인"/></td>
				</tr>
				
				<tr><input type="hidden" name="id" value="${login.id }"/></tr>
			</table>
			
			<table id="table2">
				<tr>			
					<td colspan=2><button type="button" onclick="history.back()">취소</button>
					<button>변경</button></td>
				</tr>
			</table>
	</form>
	</div>
</div>
</body>
</html>