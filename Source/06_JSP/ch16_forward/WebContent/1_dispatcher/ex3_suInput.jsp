<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<% int a = 5; %>
	<h2>a : <%= a %></h2>
	<!-- EL 표기법으로는 스크립트릿으로 선언한 것을 사용할 수 없다 -->
	<h2> a: ${a } 이건 호출이 안됩니다. </h2>
	
<!-- 	<form action="ex3_suPro.jsp"> -->
	<form action="<%=conPath%>/Ex3">
		누적을 원하는 수 <input type="number" min="1" name="su" required="required">
		<input type="submit" value="누적">
	</form>
	
</body>
</html>