<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%
		// post 방식으로 받아왔기 때문에 인코딩 반드시!
		request.setCharacterEncoding("utf-8");
	
		// 내가 폼에서 입력한 값을 파라미터로 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// 세션에 저장
		session.setAttribute("id", id); 
		session.setAttribute("pw", pw); 
		session.setAttribute("name", name);
		
		// 화면에 뿌려주기
	%>
	
	<!-- 화면에 뿌려주는 작업 -->
	<h2><%=name %>님 약관에 동의하십니까?</h2>
	<hr>
	<ol>
		<li>회원정보는 웹사이트 운영을 위해서만 나옴</li>
		<li>운영에 방해되면 강제퇴장 조치가 이루어질 수 있음</li>
	</ol>
	<hr>
	<fieldset>
		<legend>약관동의</legend>
			<form action="joinOk.jsp">
				<input type="radio" name="agree" value="y" class="btn">동의
				<input type="radio" name="agree" value="n" checked="checked" class="btn">비동의
				<input type="submit" value="확인" class="btn">
			</form>
	</fieldset>
</body>
</html>