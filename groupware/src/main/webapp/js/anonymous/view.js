$(document).ready(function() {
	$(".replyUpdateForm").hide();
	
	$(".replyUpdateBtn").click(function() {
		$(this).parent().parent().parent().find(".replyItem").hide();
		$(this).parent().parent().parent().find(".replyUpdateForm").show();
	});
	
	$(".replyUpdateCancel").click(function() {
		$(this).parent().parent().parent().parent().find(".replyUpdateForm").hide();
		$(this).parent().parent().parent().parent().find(".replyItem").show();
	});
});