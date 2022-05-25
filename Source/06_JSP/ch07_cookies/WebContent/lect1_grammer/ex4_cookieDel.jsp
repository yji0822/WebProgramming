<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	a {
		color: red;
		text-decoration: none;
	}
	</style>
</head>

<body>
	<!-- 로그아웃 하는 경우 -->
	<h1>특정 쿠키(쿠키 이름이 cookieName인 쿠키) 삭제</h1>
	
	<%
		Cookie[] cookies = request.getCookies(); // 쿠키 가져옴
		if(cookies != null) {
			// 쿠키가 값이 있을 때 > null이면 아무런 조취를 하지 않을 것이다.
			for(Cookie c : cookies) {
				String name = c.getName();
				if(name.equals("cookieName")) {
					// 쿠키 삭제 : 유효기간이 0초 짜리인 같은 이름의 쿠키를 만들어 덮어 씌워준다.
					Cookie cookie = new Cookie("cookieName", "cookieValue"); 
					// 어차피 0초 뒤면 지워질 쿠키로 value 는 어떤 값을 넣어도 상관없다. cookieName은 반드시 동일하게!
					cookie.setMaxAge(0); // 0초 뒤에 사라지는 쿠키 (실행하자마자 바로 사라지는 쿠키)
					response.addCookie(cookie); // 기존에 있는 쿠키에 덮어 쓴다.
					out.println("<h3>쿠키 삭제 성공</h3>");					
					// 세션은 서버에 있는 것, 쿠키는 사용자가 가지고 있는 것으로 삭제가 불가하다.
					break;
				} //if
			} // for
		} // if
	%>
	
	<hr>
	<a href="ex1_cookieConstruct.jsp"> 쿠키생성(cookieName)) </a> <br>
	<a href="ex2_cookieList.jsp"> 쿠키들(쿠키이름-쿠키값) 리스트 확인 </a><br>
	<a href="ex3_thatCookie.jsp"> 특정 쿠키(이름이 cookieName인 것) 찾기 </a><br>
	<a href="ex4_cookieDel.jsp"> 쿠키 삭제 </a> <!-- (id란 이름의 쿠키를 갖고 있는지 아닌지 확인) -->

</body>
</html>