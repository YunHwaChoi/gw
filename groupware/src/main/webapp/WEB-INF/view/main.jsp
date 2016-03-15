<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/groupware/css/main.css">
</head>
<body>
	<div class="division">
		<ul>
			<a href="notice/list.do">
				<li class="li_head"><i class="fa fa-bullhorn"></i>&nbsp;공지사항</li>
			</a>
			<c:forEach var="notice" items="${noticeList }">
				<a href="notice/view.do?no=${notice.no }">
					<li class="li_content">
						${notice.wdate }
						${notice.title }
					</li>
				</a>
			</c:forEach>
		</ul>
	</div>
	
	<div class="division">
		<ul>
			<a href="schedule/list.do">
				<li class="li_head"><i class="fa fa-calendar"></i>&nbsp;일정관리</li>
			</a>
			<c:forEach var="schedule" items="${scheduleList }">
				<a href="schedule/view.do?no=${schedule.no }">
					<li class="li_content">
						${schedule.year}-${schedule.month}-${schedule.day} ${schedule.time }시 
						${schedule.title }
					</li>
				</a>
			</c:forEach>
		</ul>
	</div>

	<div class="division">
		<ul>
			<a href="draft/proceed/list.do">
				<li class="li_head"><i class="fa fa-file-text-o"></i>&nbsp;결재할 문서</li>
			</a>
			<c:forEach var="draft" items="${draftList }">
				<a href="draft/proceed/view.do?no=${draft.no }">
					<li class="li_content">
						${draft.regDate }
						${draft.title }
					</li>
				</a>
			</c:forEach>
		</ul>
	</div>
	
	<div class="division">
		<ul>
			<a href="message/list.do">
				<li class="li_head"><i class="fa fa-envelope-o"></i>&nbsp;받은 쪽지</li>
			</a>
			<c:forEach var="message" items="${messageList }">
				<a href="message/view.do?no=${message.no }">
					<li class="li_content">
						${message.sdate }
						${message.title }
					</li>
				</a>
			</c:forEach>
		</ul>
	</div>
</body>
</html>