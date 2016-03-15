/**
 * 주로 사용하는 유틸리티 함수 정의
 */

// *** 입력 항목이 비어 있는지 확인하는 함수 *** //
function isEmpty(item, msg) {
	// alert("isEmpty()");
	// item이 비어 있으면
	if ($(item).val() == "") {
		// 경고창 띄우기
		alert(msg);
		// 커서를 item에 위치시킨다.
		$(item).focus();
		// 데이터가 비어 있으면 true
		return true;
	} // if 끝
} // isEmpty 끝
