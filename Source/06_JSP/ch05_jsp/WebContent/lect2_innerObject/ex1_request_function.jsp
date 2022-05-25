<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- jsp 내부 객체 : response, request -->
	<!--  IPv4 : 127.0.0.1 (192.168.10.30) -->
	<!-- 표현식 안에는 따로 세미콜론을 붙이면 안된다.  -->
	<h2>요청한 곳의 주소 : ★ <%=request.getRemoteAddr() %></h2>
	<!-- 출력결과 : 요청한 곳의 주소 : 0:0:0:0:0:0:0:1 -->
	
	<!-- IPv6에서 IPv4로 바꾸는 작업 해주기 -->
	<h2>컨텍스트 path : ★ <%=request.getContextPath()%> </h2>
	<h2>요청방식 : <%=request.getMethod() %> </h2>
	<h2>세션객체 : ★ <%=request.getSession() %> </h2>
	<!-- 로그인할때 많이 쓰는 세션객체 -->

	<h2>요청URL : <%=request.getRequestURL() %> </h2>
	<h2>요청URI : ★ <%=request.getRequestURI() %> </h2>
	<h2>해당 프로토콜 : <%=request.getProtocol() %> </h2>
	<h2>서버 이름 : <%=request.getServerName() %> </h2>
	<h2>포트번호 : <%=request.getServerPort() %> </h2>
</body>
</html>