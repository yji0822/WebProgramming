<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>

	<!-- request객체들이 넘어온 상태 -->
	<h2>ex2_view.jsp 파일 입니다.</h2>
	<h2>회원정보</h2>
	<h3> ID : ${requestScope.member.id }</h3>
	<h3> PW : ${member.pw }</h3>
	<h3> 등록일 : ${member.rdate }</h3>
	<hr>
	<!-- 값이 동일하게 넘어온다. -->
	<h3>넘어온 파라미터 ID : ${param.id }</h3>
	<h3>넘어온 파라미터 PW : ${param.pw }</h3>
	<button onclick="history.go(-1)">이전</button>
	<!--  input 부터 실행 -->
</body>
</html>