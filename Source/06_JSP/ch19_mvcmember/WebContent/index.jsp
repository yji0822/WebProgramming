<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	
	<jsp:forward page="list.do"/> <!-- boardController 서블릿으로 이동 -->
	
	
</body>
</html>