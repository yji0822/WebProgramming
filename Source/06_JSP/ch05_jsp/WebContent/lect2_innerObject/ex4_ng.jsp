<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- age.jsp > age1.jsp > ng.jsp -->
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>
		<h2><%=age %>살은 미성년자이므로 주류 구매 절 대 불 가!!합니다.</h2>
		<button onclick="history.go(-1);">뒤로가기</button>
		<!-- 뒤로가기를 눌렀을때 age1.jsp에 가야하는데 화면에 안나타는 페이지는 저장되지 않고
		age.jsp가 화면에 보여진다. -->
</body>
</html>