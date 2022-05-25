<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!--  ex1_forward.jsp?n=1로 요청 -->

	<h2>ex1_forward.jsp 페이지 입니다.</h2>

	<%// response.sendRedirect("ex2_forward.jsp"); 
	// 기존의 request객체는 버리고  request객체가 새로 만들어진다. (전달받은 파라미터가 (ex. n=1) 전달 안됨) %>
	<!-- index.html은 전달할 파라미터가 없기 때문에 sendRedirect 해주고 이외에는 forward를 사용해준다. -->
	
	<jsp:forward page="ex2_forward.jsp"/> 
	<!-- 반드시 닫아주어야 한다. -->

</body>
</html>