<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 선언문은 보통 위에 작성하여 준다. -->
		<%! String name, id, password; %>
		<%
		request.setCharacterEncoding("utf-8"); // post방식으로 파라미터 전송시에만 사용한다.(인코딩)
		name = request.getParameter("name");
		id = request.getParameter("id");
		password = request.getParameter("password");
		%>
	<h3>결과 화면</h3>
	<p>아이디는 <%= id %>이고
	패스워드는 <%= password %>입니다. <br>
	<%= name %>님 반갑습니다!
	</p>
	<!-- 한글로 입력했을 경우에는 요상한 문자가 나오는 경우가 발생 -->
</body>
</html>