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
		String sessionName = (String)session.getAttribute("SESSION_NAME");
		Integer myNum = (Integer)session.getAttribute("MY_NUM");
		
		out.println("SESSION_NAME의 SESSION값은" + sessionName + "<br>");
		out.println("MY_NUM의 SESSION값은 " + myNum + "<br>");
	%>
</body>
</html>