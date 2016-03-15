$(document).ready(function() {
	$("#form1").submit(function() {
		if($("#title").val() == "") {
			alert("제목을 입력하세요");
			$("#title").focus();
			return false;
		}
		else if($("#content").val() == "") {
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		}
	});
});