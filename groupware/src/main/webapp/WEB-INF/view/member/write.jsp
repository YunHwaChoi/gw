<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/member/write.css" rel="stylesheet" type="text/css" /> 
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
		// 데이터 검사 - 1. ID
			if($("#id").val()==""){
				alert("사원번호(ID)를 입력하셔야 합니다.");
				// 커서를 사원번호(ID)칸에 위치시키기
				$("#id").focus();
				return false;
			}
		// 데이터 검사 - 2. PW
			if($("#pw").val()==""){
				alert("비밀번호를 입력하셔야 합니다.");
				$("#pw").focus();
				return false;
			}
			// 데이터 검사 - 3. 이름
			if($("#name").val()==""){
				alert("이름을 입력하셔야 합니다.");
				$("#name").focus();
				return false;
			}
			// 데이터 검사 - 4. 소속부서
			if($("#dep").val()=="--소속부서 선택--"){
				alert("소속부서를 선택하셔야 합니다.");
				$("#dep").focus();
				return false;
			}
			// 데이터 검사 - 5. 직위번호
			if($("#pnoSel").val()=="--직위번호 선택--"){
				alert("직위번호를 선택하셔야 합니다.");
				$("#pnoSel").focus();
				return false;
			}
			// 데이터 검사 - 6. 매니저
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
<div id="writeDiv">
<!-- <h2>사원 등록</h2> -->
	<div id="formDiv">
	<form id="form" action="write.do" method="post">
	
		<table>
			<tr>
				<td><label for="id">사원ID</label></td>
				<td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td>
				<td><input type="password" name="pw" id="pw"/></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name" name="name"/></td>
			</tr> 
		
<!-- 		<label for="dep">소속 부서</label><select id="dep" name="dep"></select><br/> -->
<!-- 		<select id="pno" name="pno"></select><br/> -->

			<tr>
				<td><label for="dep">소속 부서</label></td>
				<td>
				<select id="dep" name="dep">
					<option>--소속부서 선택--</option>
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
				<td><label for="pnoSel">직위번호</label></td>
				<td>
					<select id="pnoSel">
					<option>--직위번호 선택--</option>
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
				<td><input type="text" id="manager" name="manager"/></td>
			</tr>
			<tr>
				<td><label for="tel">전화번호</label></td>
				<td><input type="text" id="tel" name="tel"/></td>
			</tr>
			<tr>
				<td><label for="phone">핸드폰</label></td>
				<td><input type="text" id="phone" name="phone"/></td>
			</tr>
		</table>
		<table id="table2">
			<tr>
				<td><button type="button" onclick="history.back()">취소</button>
				<button>등록</button>
				</td>
			</tr>			
		</table>
		
	</form>
	</div>
	</div>
</body>
</html>