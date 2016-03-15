<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/data/write.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../js/common/util.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
// 		alert("test");
		$("#form").submit(function() {
			//데이터 검사 - 1. ID
			if ($("#title").val() == "") {
				alert("제목을 입력하셔야 합니다.");
				// 커서를 제목칸에 위치시키기
				$("#title").focus();
				return false;
			}
			// 데이터 검사 - 2. 내용
			if ($("#content").val() == "") {
				alert("내용을 입력하셔야 합니다.");
				// 커서를 내용칸에 위치시키기
				$("#content").focus();
				return false;
			}
		});

	});
</script>
</head>
<body>
<div id="writeDiv">
<!-- 	<h2>자료게시판 글쓰기</h2><br/> -->
		<div id="formDiv">
		<form id="form" action="write.do" method="post" enctype="multipart/form-data">
	<fieldset id="formField">
		<ul>
			<li><label for="title">제목</label><input type="text" name="title" id="title" maxlength="15"/></li>
			<li><label for="writer">작성자</label><input value="${login.name }" id="writer" readonly="readonly"/></li>
			<li ><label for="content">내용</label><textarea name="content" id="content" maxlength="200"></textarea></li>
			<li><label for="file">첨부 파일</label><input type="file" name="file" id="file"/></li>
			<li><input type="hidden" id="writer" name="writer" value="${login.id }"/></li>
		</ul>
		
		<button type="button" onclick="history.back()">취소</button>
		<button>작성</button>
		
	</fieldset>
	</form>
	</div>
	</div>
</body>
</html>