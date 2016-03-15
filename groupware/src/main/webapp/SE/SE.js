$(function() {
	//전역변수선언
	var editor_object = [];

	nhn.husky.EZCreator.createInIFrame({
		oAppRef : editor_object,
		elPlaceHolder : "content",
		sSkinURI : "../SE/SmartEditor.html",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : false,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : false,
		}
	});
	
	//전송버튼 클릭이벤트
    $(".submit").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
         
        // 이부분에 에디터 validation 검증
       
        if(checkNull()) {
        	return true;
        }
        else
        	return false;
    });
});