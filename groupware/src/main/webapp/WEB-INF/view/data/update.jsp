<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/data/update.css" rel="stylesheet" type="text/css" /> 
<title>Insert title here</title>
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../js/common/util.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
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
<div id="updateDiv">
<!-- 	<h2>자료게시판 글 수정</h2> -->
	<div id="formDiv">
	<form id="form" action="update.do" method="post" enctype="multipart/form-data">
		<fieldset id="formField">
			<ul>
				<li><input type="hidden" name="no" value="${data.no }"/></li>
				<li><label for="title">글제목</label><input type="text" name="title" id="title" value="${data.title }"/></li>
				<li><label for="content">글내용</label><textarea rows="7" cols="60" name="content" id="content">${data.content}</textarea></li>
				<li><label for="writer">작성자</label><input type="text" name="writer" value="${data.writer }" readonly="readonly"/></li>
				<li><label for="file">첨부 파일</label><input type="file" name="file" id="file" value="${data.fileName }"/></li>
			</ul>
			
			<button type="button" onclick="history.back()">취소</button>
			<button>수정</button>
		</fieldset>
	
	</form>
</div>
</div>
</body>
</html>