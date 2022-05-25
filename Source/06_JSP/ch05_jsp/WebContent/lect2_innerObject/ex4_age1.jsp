<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	// 보이지 않는 페이지.
		int age = Integer.parseInt(request.getParameter("age"));
		if(age >= 19) {
			response.sendRedirect("ex4_pass.jsp?age=" + age); // 진짜 많이 나오는 함수이다.
			// 다음 페이지로 넘어가면 몇살을 입력했는지 잊기 때문에 같이 넘어갈 수 있도록 입력해준다
		} else {
			response.sendRedirect("ex4_ng.jsp?age=" + age);
		}
	%>
</body>
</html>