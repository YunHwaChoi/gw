//$(document).ready(function() {
////	$("#sign").hide();
//});
//
//$(window).load(function() {
//	var html = $("#ifrm").contents().find("body");
//	
//	html.find("#viewNo").text($("#no").val());
//	html.find("#viewRegDate").text($("#regDate").val());
//	html.find("#viewSignDate").text($("#isSign3").val());
//	
//	if($("#name").val() == html.find("#viewSigner1").text()) {
////		html.find("#viewSign1").append($("#sign"));
//		html.find("#viewSign1").append
//	}
//	else if($("#name").val() == html.find("#viewSignerName2").text()) {
////		html.find("#viewSign2").append($("#sign"));
//		
//	}
//	else if($("#name").val() == html.find("#viewSignerName3").text()) {
////		html.find("#viewSign3").append($("#sign"));
//		
//	}
//});

$(document).ready(function() {
	$("#viewNo").text($("#no").val());
	$("#viewRegDate").text($("#regDate").val());
	$("#viewSignDate").text($("#isSign3").val());
	
	if($("#isSign1").val() != "")
		$("#viewSign1").html("<i class='fa fa-check'></i>");
	
	if($("#isSign2").val() != "")
		$("#viewSign2").html("<i class='fa fa-check'></i>");
	
	if($("#isSign3").val() != "")
		$("#viewSign3").html("<i class='fa fa-check'></i>");
	
	$("#sign").hide();
	
	if(($("#isSign1").val() == "") && ($("#viewSigner1").text() == $("#name").val())) {
		$("#viewSign1").append($("#sign"));
		$("#sign").show();
	}
	else if(($("#isSign2").val() == "") && ($("#viewSignerName2").text() == $("#name").val())) {
		$("#viewSign2").append($("#sign"));
		$("#sign").show();
	}
	else if(($("#isSign3").val() == "") && ($("#viewSignerName3").text() == $("#name").val())) {
		$("#viewSign3").append($("#sign"));
		$("#sign").show();
	}
});