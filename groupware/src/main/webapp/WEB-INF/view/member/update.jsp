<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/member/update.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../js/common/util.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#form").submit(function() {
			switch($("#pnoSel").val()) {
			case "인턴":
				$("#pno").val(1);
				break;
			case "사원":
				$("#pno").val(2);
				break;
			case "대리":
				$("#pno").val(3);
				break;
			case "과장":
				$("#pno").val(4);
				break;
			case "차장":
				$("#pno").val(5);
				break;
			case "부장":
				$("#pno").val(6);
				break;
			case "본부장":
				$("#pno").val(7);
				break;
			case "사장":
				$("#pno").val(8);
				break;
			case "관리자":
				$("#pno").val(9);
				break;
			}
			
		// 데이터 검사 - 1. 이름
		if($("#name").val()==""){
			alert("이름을 입력하셔야 합니다.");
			$("#name").focus();
			return false;
		}

		// 데이터 검사 - 2. 매니저
		if($("#manager").val()==""){
			alert("매니저를 입력하셔야 합니다.");
			$("#manager").focus();
			return false;
		}
	});
	});
</script>
</head>
<body>
<div id="updateDiv">
<!-- <h2>사원 정보 수정</h2> -->
	<div id="formDiv">
	<form id="form" action="update.do" method="post">
	
<!-- 	<fieldset> -->
		<table>
			<tr>
				<td><label for="id">사원번호(ID)</label></td>
				<td><input type="text" id="id" name="id" value="${member.id }" readonly="readonly"/></td>
			</tr>
			
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name" name="name" value="${member.name }"/></td> 
			</tr>
		
			<tr>
				<td>
				<label for="dep">소속부서</label>
				</td>
				<td>
				<select id="dep" name="dep">
					<option>${member.dep }</option>
					<option>마케팅</option>
					<option>재무</option>
					<option>개발</option>
					<option>인사</option>
					<option>경영지원</option>
					<option>기획</option>
					<option>영업</option>
					<option>영업지원</option>
				</select>
				</td>
			</tr>
		
			
			<tr>
				<td>
				<label for="pnoSel">직위번호</label>
				</td>
				<td>
				<select id="pnoSel">
					<option>${member.position }</option>
					<option>인턴</option>
					<option>사원</option>
					<option>대리</option>
					<option>과장</option>
					<option>차장</option>
					<option>부장</option>
					<option>본부장</option>
					<option>사장</option>
					<option>관리자</option>
			</select>
			</td>
			</tr>
		
			<tr><input type="hidden" id="pno" name="pno"></tr>
			
			<tr>
			<td><label for="manager">매니저</label></td>
			<td><input type="text" id="manager" name="manager" value="${member.manager }"/></td>
			</tr>
			
			<tr>
			<td><label for="tel">전화번호</label></td>
			<td><input type="text" id="tel" name="tel" value="${member.tel }"/></td>
			</tr>
			
			<tr>
			<td><label for="phone">핸드폰</label></td>
			<td><input type="text" id="phone" name="phone" value="${member.phone }"/></td>
			</tr>
			
			<tr><input type="hidden" id="pno" name="pno" value="${member.pno }" /></tr>
		
		</table>
		
			<table id="table2">
			<tr>
			<td colspan=2><button type="button" onclick="history.back()">취소</button>
			<button>변경</button>
			</td>
			</tr>
			</table> 
	</form>
</div>
</div>
</body>
</html>