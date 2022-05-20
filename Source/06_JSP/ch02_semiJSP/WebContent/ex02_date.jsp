<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	// ctrl + space bar 눌러서 자동완성으로 import하기
	Date now = new Date();
	String str = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분", now); // Date()
	Calendar now2 = Calendar.getInstance(); // 10장 싱글톤패턴
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일은 좋은 날!");
	String str2 = sdf.format(now2.getTime());
	%>
	<%= str %><br>
	<%= str2 %>
	
	<%-- JSP주석 --%>
	<!--  HTML 주석 -->
</body>
</html>