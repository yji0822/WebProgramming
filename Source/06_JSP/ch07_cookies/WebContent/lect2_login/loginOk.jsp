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

	<%! String id, pw; %>
	<!-- 선언할때는 항상 주의해서 하자 -->
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		// 입력받은 id, pw가 DB에 있는지 확인하는 절차
		if (id != null && id.equals("aaa") && pw!=null && pw.equals("1111")) {
			// 로그인 처리 
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(-1); // 유효시간은 브라우저 닫을 때까지 유효함
			response.addCookie(cookie); // 불러오기
			Cookie cookie2 = new Cookie("name", "홍길동"); //DB에서 가져온 이름을 쿠키값으로
			cookie2.setMaxAge(-1);
			response.addCookie(cookie2); // 로그인처리 끝
			response.sendRedirect("welcome.jsp");
		} else {
			// id와pw가 올바른 값이 들어오지 않았을 경우 %>
		<script>
			alert('아이디와 비밀번호를 확인하세요');
			location.href = "login.html";
		</script>		
		<!-- 반드시 login.html에서 실행하기 -->
		<%
		}
		%>	

</body>
</html>