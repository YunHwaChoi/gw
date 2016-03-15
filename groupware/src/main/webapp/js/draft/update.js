var num = 0;

function getReturnValue(returnValue) {
	if(num == 2) {
		$("#signerName2").val(returnValue.name);
		$("#signer2").val(returnValue.id);
	}
	else if(num == 3) {
		$("#signerName3").val(returnValue.name);
		$("#signer3").val(returnValue.id);
	}
	$(".signerName").blur();
}

function openNewWindow() {
	var url = "../../member/selectSigner.do";
 	var name = "_blank";
 	var specs = "menubar=no, status=no, toolbar=no, resizable=no, width=480px, height=700px, top=40px, left=200px";
 	var newWindow = window.open(url, name, specs);
 	newWindow.focus();
}

function checkNull() {
	if($("#title").val() == "") {
		alert("제목을 입력해 주세요");
		$("#title").focus();
		return false;
	}
	else if($("#signerName2").val() == "") {
		alert("제2결재자를 선택해주세요");
		$("#signerName2").focus();
		return false;
	}
	else if($("#signerName3").val() == "") {
		alert("제3결재자를 선택해주세요");
		$("#signerName3").focus();
		return false;
	}
	else if($("#form1").find("iframe").is(":hidden")) {
		alert("내용을 작성해주세요");
		return false;
	}
	else
		return true;
}

$(document).ready(function() {
	$(".signerName").focus(function() {
	 	if(this.id == "signerName2")
	 		num = 2;
	 	else
	 		num = 3;
	 	openNewWindow();
	});
	
});

$(window).load(function() {
	if($("#title").val() == "") {
		alert("제목을 입력해 주세요");
		$("#title").focus();
		return;
	}
	else if($("#signer2").val() == "") {
		alert("제2결재자를 선택해주세요");
		$("#signerName2").focus();
		return;
	}
	else if($("#signer3").val() == "") {
		alert("제3결재자를 선택해주세요");
		$("#signerName3").focus();
		return;
	}
	
	var html = $("iframe").contents().find("body");
	
	html.find("#viewNo").text($("#no").val());
	html.find("#viewRegDate").text($("#regdate").val());
	
	$("#title").attr("readonly", true);
	$("#signerName2").attr("readonly", true);
	$("#signerName3").attr("readonly", true);
	$(".signerName").off("focus");
	
	$("#load").click(function() {
		var param = "" + 
		"<div style='min-width: 21cm; max-width: 21cm; min-height: 29.7cm; max-height: 29.7cm; text-align: center; background: white;'>" +
			"<div style='min-width: calc(100% - 60mm); min-height: 876.851px; padding: 35mm 30mm 30mm 30mm;'>" +
				"<table class='__se_tbl' style='width: 100%; min-height: 876.851px; border: 1px solid white; border-collapse: collapse;'>" +
					"<tbody>" +
						"<tr>" +
							"<td style='border: 1px solid black; width: 70px; height: 40px;'>문서번호</td>" +
							"<td style='border: 1px solid black; width: 120px; height: 40px;' id='viewNo'></td>" +
							"<td colspan='1' rowspan='3' style='width: 104px;'></td>" +
							"<td colspan='1' rowspan='3' style='border: 1px solid black; width: 40px;'>결재</td>" +
							"<td style='border: 1px solid black; width: 70px;' id='viewSigner1'>" + $("#signer1").val() + "</td>" +
							"<td style='border: 1px solid black; width: 70px;' id='viewSignerName2'>" + $("#signerName2").val() + "</td>" +
							"<td style='border: 1px solid black; width: 70px;' id='viewSignerName3'>" + $("#signerName3").val() + "</td>" +
						"</tr>" +
						"<tr>" +
							"<td style='border: 1px solid black; width: 70px; height: 40px;'>기안자</td>" +
							"<td style='border: 1px solid black; width: 120px; height: 40px;' id='viewDrafter'>" + $("#signer1").val() + "</td>" +
							"<td colspan='1' rowspan='2' style='border: 1px solid black; width: 70px;' id='viewSign1'></td>" +
							"<td colspan='1' rowspan='2' style='border: 1px solid black; width: 70px;' id='viewSign2'></td>" +
							"<td colspan='1' rowspan='2' style='border: 1px solid black; width: 70px;' id='viewSign3'></td>" +
						"</tr>" +
						"<tr>" +
							"<td style='border: 1px solid black; width: 70px; height: 40px;'>기안일자</td>" +
							"<td style='border: 1px solid black; width: 120px; height: 40px;' id='viewRegDate'></td>" +
						"</tr>" +
						"<tr>" +
							"<td style='border: 1px solid black; width: 70px; height: 40px;'>결재일자</td>" +
							"<td style='border: 1px solid black; width: 120px; height: 40px;' id='viewSignDate'></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
						"</tr>" +
						"<tr>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
							"<td></td>" +
						"</tr>" +
						"<tr>" +
							"<td colspan='7' style='height: 30px;'></td>" +
						"</tr>" +
						"<tr>" +
							"<td colspan='7' style='height: 70px; font-weight: bolder; font-size: 30pt;'>" + $("#title").val() + "</td>" +
						"</tr>" +
						"<tr>" +
							"<td colspan='7' style='height: 20px;'></td>" +
						"</tr>" +
						"<tr>" +
							"<td colspan='7' style='border: 1px solid black; height: 30px;'>본문</td>" +
						"</tr>" +
						"<tr>" +
							"<td colspan='7' style='border: 1px solid black; height: 100%; text-align: left; padding: 20px;'>내용 입력</td>" +
						"</tr>" +
					"</tbody>" +
				"</table>" +
			"</div>" +
		"</div>"
		
		var inputarea = $("iframe").contents().find("#se2_iframe").contents().find("body");
		
		inputarea.html(param);
		
		$("#form1").find("iframe").show();
		$(".btnBoxR").show();
		$(".btnBox").css("margin-bottom", "20px");
		$("#title").attr("readonly", true);
		$("#signerName2").attr("readonly", true);
		$("#signerName3").attr("readonly", true);
		$(".signerName").off("focus");
	});
	
	$("#cancel").click(function() {
		$("#title").val("");
		$("#signerName2").val("");
		$("#signerName3").val("");
		$("#title").attr("readonly", false);
		$("#signerName2").attr("readonly", false);
		$("#signerName3").attr("readonly", false);
		$("#form1").find("iframe").hide();
		$(".btnBoxR").hide();
		$(".btnBox").css("margin-bottom", "0");
		$(".signerName").focus(function() {
		 	if(this.id == "signerName2")
		 		num = 2;
		 	else
		 		num = 3;
		 	openNewWindow();
		});
	});
});