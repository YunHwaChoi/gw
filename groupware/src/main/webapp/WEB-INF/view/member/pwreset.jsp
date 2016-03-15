<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/member/pwreset.css" rel="stylesheet" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="pwresetDiv">
<!-- <h2>사원 비밀번호 수정</h2> -->
	<div id="formDiv">
	<form id="form" action="pwreset.do" method="post">
			<table>
				<tr>
					<td><label for="id">사원번호(ID)</label></td>
					<td><input type="text" id="id" name="id" value="${member.id }" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" id="name" name="name" value="${member.name }" readonly="readonly"></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호</label></td>
					<td><input type="password" id="pw" name="pw"/></td>
				</tr>
				
				<tr><input type="hidden" name="id" value="${member.id}"></tr>
			</table>
			<table id="table2">
				<tr>
				<td colspan="2"><button type="button" onclick="history.back()">취소</button>
				<button>변경</button>
				</td>
				</tr>
			</table>
	</form>
	</div>
	</div>
</html>
