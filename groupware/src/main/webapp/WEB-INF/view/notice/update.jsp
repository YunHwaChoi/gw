<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글수정</title>
<link href="../css/notice/update.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
// 		alert("수정");
		$("#noticeForm").submit(function(){
			// 제목
			if($('#title').val()==""){
				alert("제목을 입력해주세요");
				$('$title').focus();
				return false;
			}
			// 내용
			if($('#content').val()==""){
				alert("제목을 입력해주세요");
				$('$content').focus();
				return false;
			}
		});
	});
</script>
</head>
<body id="noticeBody">
<div id="noticeUpdateDiv">
<form id="noticeForm" action="update.do?page=${page }" method="post" enctype="multipart/form-data">
	
	<button id="noticeBtn" type="submit">수정</button>
	<button id="noticeBtn" type="button" onclick="history.back()">취소</button><br/><br/>

	<fieldset id="noticeUpdateField">
	<ul id="noticeUl">
	<li id="noticeLi">
	<input type="hidden" name="no" value="${notice.no }" />
	<label for="title">글제목</label><input type="text" name="title" id="title" value="${notice.title }" required="required"/><br/>
	</li>
	<li id="noticeLi">
	<label for="content">글내용</label>
	<textarea style="resize:none;" name="content" required="required">${notice.content }</textarea>
	</li>
	<li id="noticeLi">
	<label for="writer">작성자</label><input type="text" name="writer" value="${notice.writer }" readonly="readonly"/><br/>
	</li>
	<li id="noticeLi">
	<label for="file">파일첨부</label><input type="file" id="file" name="file1"><br/>
	</li>
	<c:if test="${!empty notice.fileName }">
	<li id="noticeLi">
		<label for="fileName">첨부된 파일 : </label><span id="fileName">${notice.fileName }</span>
		</li>
	</c:if>
	</ul>
	</fieldset>	
</form>
</div>
</body>
</html>