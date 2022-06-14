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

	<!-- ex3_suInput.jsp 부터 실행 -->
	<h2>ex3_suView.jsp 페이지 입니다.</h2>
	<h3>1부터 ${param.su }까지의 누적합은 ${sum }입니다.</h3>
	<button onclick="history.back()">이전</button>
	<button onclick="location.href='<%=conPath %>/1_dispatcher/ex3_suInput.jsp'">다시 입력</button>
	<!-- url 기준으로 만들기 때문에 폴더명이 들어가야 한다. -->
</body>
</html>