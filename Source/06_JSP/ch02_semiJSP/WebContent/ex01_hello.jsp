<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Insert title here</title>
	<script>

	</script>
</head>
<body>
	<h1>Hello, World</h1>
	<!-- 자바를 넣고 싶다면? <% %>-->
	<%
	int total = 0;
	for(int i=1; i<=100; i++) {
		total += i;
	}
	%>
	<!-- 출력은 html -->
	<h2>1부터 100까지 누적합은 total 입니다 XXX</h2>
	<h2>1부터 100까지 누적합은 <%=total %> 입니다 OOO </h2>
	<!-- ctrl + f11 -->
	
</body>
</html>