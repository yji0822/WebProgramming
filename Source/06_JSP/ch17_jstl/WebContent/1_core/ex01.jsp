<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!-- uri : 태글 라이브러리가 있는 곳 prefix : 앞에 사용할 문구  (c:if) 를 사용할 수 있다.
    core와 fmt를 가장 많이 사용한다.-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h2>core 라이브러리</h2>
	<!-- 1부터 3까지 1씩 증가해서 forEach문을 실행한다. var가 변수 -->
	<c:forEach var="i" begin="1" end="3" step="1">
		<h1> ${i }번째, 안녕하세요!!!</h1>
	</c:forEach>
	
	<%
	// 위에와 같은 의미 - 이제는 사용을 안할 예정
		for(int i= 1; i<=3 ; i++) {
			out.println("<h2>" + i + "번째, 안녕하세용</h2>");
		}
	%>
	
	<!-- 변수들도 scope로 선언할 수 있다. -->
	
	
	<!-- ##은 있으면 나오고 아니면 안나오고. 0은 존재하던 존재하지 않던 무조건 출력을 해준다. -->
	<h2>fmt(formatting) 라이브러리</h2>
	<fmt:formatNumber value="3333.149" pattern="#,###.00" />
	
	<h2>그 외 라이브러리 (funtions 라이브러리)</h2><!-- fn 라이브러리는 el 표기법과 함께 사용한다. -->
	<!-- 실행 후에 .jsp?id=aaa 를 추가로 적어준 후에 실행해본다 -->
	ID파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
	
</body>
</html>