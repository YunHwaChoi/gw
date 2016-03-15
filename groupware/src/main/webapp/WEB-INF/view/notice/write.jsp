<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/notice/write.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<title>공지사항 글쓰기</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#noticeForm").submit(function(){
// 			alert("공지사항 작성");
			// 제목
			if($('#title').val()==""){
				alert("제목을 입력해주세요");
				$("#title").focus();
				return false;
			}
			// 내용
			if($('#content').val()==""){
				alert("내용을 입력해주세요");
				$("#content").focus();
				return false;
			}
		});
	});
</script>
</head>
<body id="noticeBody">
<!-- 반드시 post! update후에는 redirect를 통해 view.do로 간다. -->

<div id="noticeWriteDiv">
<form id="noticeForm" action="write.do" method="post" enctype="multipart/form-data">

<button id="noticeBtn" type="submit">작성</button>
<!-- 클릭만 되고 submit이 일어나지 않게 type을 button으로 지정한다. -->
<button id="noticeBtn" type="button" onclick="history.back()">취소</button><br/><br/>	


<fieldset id="noticeWriteField">
<ul id="noticeUl">
<li id="noticeLi">
	<label for="title">제목</label><input type="text" name="title" id="title" required="required" maxlength="50"/>
</li>
<li id="noticeLi">
	<label for="content">내용</label>
	<textarea style="resize:none;" name="content" id="content" required="required" maxlength="1300"></textarea>

	<input type="hidden" id="writer" name="writer" value="${login.id }">
	
<li id="noticeLi">
	<label for="fileName">파일첨부</label><input type="file" name="file1">
</li>
</ul>
</fieldset>

</form>
</div>


</body>
</html>