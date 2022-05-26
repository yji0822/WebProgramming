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
		// 로그인 상태 : id, name 세션 속성이 있음
		String name = (String)session.getAttribute("name");
		if(name != null) {
			// session.removeAttribute("id"); - id 세션 지우기
			// session.removeAttribute("name"); - name 세션 지우기
			session.invalidate(); // 세션 한번에 종료 시켜주는 로직
			out.println("<h2> 성공적으로 로그아웃 되었습니다. </h2>");
		} else {
			out.println("<h2> 로그인 상태가 아닙니다.</h2>");
		}
	%>
	
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionText.jsp'">세션 들여다보기</button>
	
</body>
</html>