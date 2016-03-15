<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.dk.groupware.schedule.model.Schedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정관리</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="../css/schedule/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/common/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="../js/common/util.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
	});
</script>
</head>
<body>
	<br/>
	<%
		@SuppressWarnings("unchecked")
		List<Schedule> list = (List<Schedule>) request.getAttribute("list");
		
		Calendar cal = Calendar.getInstance(); //Calendar객체 cal생성
		int currentYear = cal.get(Calendar.YEAR); //현재 날짜 기억
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDate = cal.get(Calendar.DATE);
		String Year = request.getParameter("year"); //나타내고자 하는 날짜
		String Month = request.getParameter("month");
		int year, month;
		if (Year == null && Month == null) { //처음 호출했을 때
			year = currentYear;
			month = currentMonth;
		} else { //나타내고자 하는 날짜를 숫자로 변환
			year = Integer.parseInt(Year);
			month = Integer.parseInt(Month);
			if (month < 0) {
				month = 11;
				year = year - 1;
			} //1월부터 12월까지 범위 지정.
			if (month > 11) {
				month = 0;
				year = year + 1;
			}
		}
	%>
	<table>
		<tr>
			<td align=left width=100>
				<!-- 년 도-->
				<a href="list.do?year=<%out.print(year - 1);%>&month=<%out.print(month);%>"><i class="fa fa-arrow-circle-left"></i></a>
				<% out.print(year);	%>년
				<a href="list.do?year=<%out.print(year + 1);%>&month=<%out.print(month);%>"><i class="fa fa-arrow-circle-right"></i></a>
			</td>
			<td align=center width=200>
				<!-- 월 -->
				<a href="list.do?year=<%out.print(year);%>&month=<%out.print(month - 1);%>"><i class="fa fa-arrow-circle-left"></i></a>
				<% out.print(month + 1); %>월
				<a href="list.do?year=<%out.print(year);%>&month=<%out.print(month + 1);%>"><i class="fa fa-arrow-circle-right"></i></a>
			</td>
			<td align=right width=200>
				<%
					out.print("오늘날짜 : " + currentYear + "-" + (currentMonth + 1) + "-" + currentDate);
				%>
			</td>
			<td align=right width="100">
			<a href="write.do"><button id="submit_Btn">일정추가</button></a>
			</td>
		</tr>
	</table>
	<table border=1 style="width: 95%;" class="sche_table">
		<!-- 달력 부분 -->
		<tr>
			<td width="100" height="40" align="center" style="color: red">일요일</td>
			<td width="100" height="40" align="center">월요일</td>
			<td width="100" height="40" align="center">화요일</td>
			<td width="100" height="40" align="center">수요일</td>
			<td width="100" height="40" align="center">목요일</td>
			<td width="100" height="40" align="center">금요일</td>
			<td width="100" height="40" align="center" style="color: blue">토요일</td>
		</tr>
		<tr height=30>
			<%
				cal.set(year, month, 1); //현재 날짜를 현재 월의 1일로 설정
				int startDay = cal.get(Calendar.DAY_OF_WEEK); //현재날짜(1일)의 요일
				int end = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //이 달의 끝나는 날
				int br = 0; //7일마다 줄 바꾸기
				for (int i = 0; i < (startDay - 1); i++) { //빈칸출력
					out.println("<td>&nbsp;</td>");
					br++;
					if ((br % 7) == 0) {
						out.println("<br>");
					}
				}
				for (int i = 1; i <= end; i++) { //날짜출력
					if((br%7)==0){ // 일요일 색깔 출력
						out.println("<div><td valign='top' align='right' width='110' height='130' style='color: red;'>" + i + "<br></div>");
					}
					else if((br%7)==6){ // 토요일 색깔 출력
						out.println("<div><td valign='top' align='right' width='110' height='130' style='color: blue;'>" + i + "<br></div>");
					}
					else{
						out.println("<div><td valign='top' align='right' width='110' height='130'>" + i + "<br></div>");
					}
					
					for(Schedule schedule : list) { // 달력내 내용표시
						if(year == schedule.getYear() && month+1 == schedule.getMonth() && i == schedule.getDay())
							out.println(
								"<div id='sche_content'>"
								+ "<a href='view.do?no=" + schedule.getNo() + "'>"
								+ "* " + schedule.getTime() + "시 "
								+ schedule.getTitle() +"</a></div><br/>"
							);
					}

					out.println("</td>");
					
					br++;
					if ((br % 7) == 0 && i != end) { // 7일이후 줄바꿈
						out.println("</tr><tr height=30>");
					}
				}
				while ((br++) % 7 != 0) //말일 이후 빈칸출력
					out.println("<td>&nbsp;</td>");
			%>
		</tr>
	</table>
</body>
</html>