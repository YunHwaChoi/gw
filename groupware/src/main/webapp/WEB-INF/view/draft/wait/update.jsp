<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전자결재</title>
<script type="text/javascript" src="../../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../../SE/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="../../SE/SE_update.js"></script>
<script type="text/javascript" src="../../js/draft/update.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/draft/common.css" />
<link rel="stylesheet" type="text/css" href="../../css/draft/update.css" />
</head>
<body>
	<div class="body">
		<form action="update.do?page=${page }" method="post" id="form1">
			<div class="btnBoxL">
				<button id="submit" class="btn">작성</button>
				<button type="button" class="btn" onclick="history.back()">취소</button>
			</div>
			
			<div class="clear"></div>
			
			<table>
				<tr>
					<td>제목</td>
					<td><input id="title" id="title" name="title" value="${draft.title }"></td>
				</tr>
				<tr>
					<td>제1결재자</td>
					<td><input id="signer1" value="${login.name }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>제2결재자</td>
					<td><input id="signerName2" class="signerName" placeholder="결재자 선택" value="${draft.signerName2 }"></td>
				</tr>
				<tr>
					<td>제3결재자</td>
					<td><input id="signerName3" class="signerName" placeholder="결재자 선택" value="${draft.signerName3 }"></td>
				</tr>
			</table>
			
			<div class="btnBox">
				<button type="button" id="load" class="btn">양식 불러오기</button>
				<button type="button" id="cancel" class="btn">재작성</button>
			</div>
			
		    <textarea name="content" id="content" style="width:824px; height:1157px;">${draft.content }</textarea>
		    
		    
		    <input type="hidden" id="no" name="no" value="${draft.no }">
			<input type="hidden" id="drafter" name="drafter" value="${login.id }">
			<input type="hidden" name="dep" value="${login.dep }">
			<input type="hidden" id="signer2" name="signer2" value="${draft.signer2 }">
			<input type="hidden" id="signer3" name="signer3" value="${draft.signer3 }">
			<input type="hidden" id="regdate" name="regdate" value="${draft.regDate }">
			
			<div class="btnBoxR">
				<button id="submit" class="btn">작성</button>
				<button type="button" class="btn" onclick="history.back()">취소</button>
			</div>
		</form>
	</div>
</body>
</html>

<!--
------------------------------------------------------ 
This Application includes SmartEditor Basic. 
SmartEditor Basic contains the following license and notice below: 
  
Copyright (c) 2008 NHN Corp 
This library is free software; you can redistribute it and/or 
modify it under the terms of the GNU Library General Public 
License as published by the Free Software Foundation; either 
version 2 of the License, or (at your option) any later version. 

This library is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
Library General Public License for more details. 

You should have received a copy of the GNU Library General Public 
License along with this library; if not, write to the 
Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, 
Boston, MA 02110-1301, USA. 
------------------------------------------------------ 
-->