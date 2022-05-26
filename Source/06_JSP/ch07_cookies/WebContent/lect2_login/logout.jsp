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
	Cookie[] cs = request.getCookies();
	if(cs!=null) {
		for(Cookie c : cs) {
			if(c.getName().equals("id")){
				// id이름의 쿠키 삭제
				c.setMaxAge(0);
				response.addCookie(c); //받은 쿠키 c를 0초로 바꾼 뒤에  넣어준다.
				out.println("<h1>성공적으로 로그아웃 되었습니다.</h1>");
			} else if(c.getName().equals("name")) {
				// name이름의 쿠키 삭제
				c.setMaxAge(0);
				response.addCookie(c);
			} // if
		} // for
	} // if
	%>
	
	<p>
	<button onclick="location.href='login.html'">로그인</button>
			<button onclick = "location.href='cookielist.jsp'"> 쿠키들 확인 </button>
	</p>
	
</body>
</html>