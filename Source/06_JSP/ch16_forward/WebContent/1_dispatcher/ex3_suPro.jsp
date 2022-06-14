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

	<%
	int su = Integer.parseInt(request.getParameter("su"));
	int sum = 0; // 누적변수
	
	for(int i = 1; i<= su; i++) {
		sum += i;
	}
	%>
	
	<!-- sum은 스크립트릿 내에서 선언한 변수 이므로 지시자를 열어서 적어주어야 한다 (뷰단, 프로세스단 분리 실패) -->
	<h2>(뷰단 프로세스단 분리X) 1부터 ${param.su }까지의 누적합은 <%= sum %> 입니다.</h2>

</body>
</html>