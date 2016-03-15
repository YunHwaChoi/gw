<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/anonymous/common.css" />
<link rel="stylesheet" type="text/css" href="../css/anonymous/view.css"/>
<script type="text/javascript" src="../js/anonymous/view.js"></script>
<title>익명게시판</title>
</head>
<body>
	<div class="body">
	
		<div class="title">
			<h2>${anonymous.title }</h2>
		</div>
		
		<div class="writer">
			${fn:substring(anonymous.writer, 0, 8) }
		</div>
		
		<div class="clear"></div>
		
		<hr>
	
		<div class="hitWdate">
			<div class="wdate">
				<i class="fa fa-clock-o"></i>&nbsp;${anonymous.wdate }
			</div>
			<div class="nbsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="hit">
				<i class="fa fa-search"></i>&nbsp;${anonymous.hit }
			</div>
		</div>
		
		<div class="clear"></div>
		
		<div class="content">
			<pre>${anonymous.content }</pre>
		</div>
		
		<hr>
		
		<div class="btnDiv">
			<button class="btn" onclick="location.href='update.do?no=${anonymous.no }&page=${page }'">수정</button>
			<button class="btn" onclick="location.href='delete.do?no=${anonymous.no }&page=${page }'">삭제</button>
			<button class="btn" onclick="location.href='list.do<c:if test="${!empty page }">?page=${page }</c:if>'">목록</button>
		</div>
		
		<div class="clear"></div>
		
		<c:if test="${!empty reply }">
			<div class="replyBox">
		
				<ul>
					<c:forEach var="reply" items="${reply }">
						<li>
						
							<div class="replyItem">
								<div class="replyWriter">${fn:substring(reply.writer, 0, 8) }</div>
								<div class="replyWdate">${reply.wdate }</div>
								<div class="clear"></div>
								<div class="replyContent">${reply.content }</div>
								
								<div class="replyBtn">
									<c:if test="${reply.writer eq login.encId }">
										<button class="btn replyDeleteBtn" onclick="location.href='reply/delete.do?rno=${reply.rno }&no=${reply.no }'">삭제</button>
										<div class="nbsp">&nbsp;</div>
										<button class="btn replyUpdateBtn">수정</button>
									</c:if>
								</div>
								
								<div class="clear"></div>
							</div>
							
							<div class="replyUpdateForm">
								<form action="reply/update.do" method="post">
									<textarea class="replyUpdateContent" name="content">${reply.content }</textarea><br>
									<input type="hidden" name="writer" value="${login.encId }">
									<input type="hidden" name="rno" value="${reply.rno }">
									<input type="hidden" name="no" value="${reply.no }">
									<div>
										<button type="button" class="btn replyUpdateCancel">취소</button>
										<div class="nbsp">&nbsp;</div>
										<button class="btn replyUpdateSubmit">수정</button>
									</div>
									<div class="clear"></div>
								</form>
							</div>
							
						</li>
					</c:forEach>
				</ul>
				
				<div class="pageMove">
					<a href="view.do?no=${anonymous.no }&page=1"><i class="fa fa-step-backward"></i></a>
<%-- 					<a href="view.do?no=${anonymous.no }&page=${jspData.startPage > 1 ? jspData.startPage-jspData.pagesPerGroup : 1 }"><i class="fa fa-chevron-left"></i><i class="fa fa-chevron-left"></i></a> --%>
<%-- 					<a href="view.do?no=${anonymous.no }&page=${jspData.page > 1 ? jspData.page-1 : 1 }"><i class="fa fa-chevron-left"></i></a> --%>
				
					<c:forEach var="i" begin="${jspData.startPage }" end="${jspData.endPage }">
						<c:choose>
							<c:when test="${jspData.page eq i }">
								<span class="cpage">${i }</span>
							</c:when>
							<c:otherwise>
								<a href="view.do?no=${anonymous.no }&page=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				
<%-- 					<a href="view.do?no=${anonymous.no }&page=${jspData.totalPage > jspData.endPage ? jspData.page+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i></a> --%>
<%-- 					<a href="view.do?no=${anonymous.no }&page=${jspData.totalPage > jspData.endPage ? jspData.endPage+1 : jspData.totalPage }"><i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i></a> --%>
					<a href="view.do?no=${anonymous.no }&page=${jspData.totalPage }"><i class="fa fa-step-forward"></i></a>
				</div>
				
			</div>
		
		</c:if>
		
		<div class="replyForm">
		
			<form action="reply/write.do" method="post">
				<textarea class="replyFormContent" name="content"></textarea><br>
				<input type="hidden" name="writer" value="${login.encId }">
				<input type="hidden" name="no" value="${anonymous.no }">
				<button class="btn replyFormUpdateBtn">댓글 등록</button>
			</form>
		
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>