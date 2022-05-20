<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 지시자(<%@ ~ %>) : 페이지 속성 --%>
	<%-- 스크립트릿(<% ~ %>) : 자바코드 --%>
	<%-- 선언부(<%! ~ %>) : 변수, 함수 --%>
	
	<%
		long result = power(2,3);
	%>
	<p>2의 3제곱은 <%= result %> 입니다.</p>
	<p>9의 11제곱은 <%=power(9,11) %> 입니다. </p>
	<%-- 표현식(<%= ~%>)에는 세미콜론이 들어가면 안된다!--%>
	
	<!-- 선언부! 먼저 실행된다 -->
	<%!
		private long power(int a, int b) {
		// a와 b의 타입도 모두 적어주어야 한다.
		// 선언부 : int a의 b제곱을 return 하는 power 함수 선언
		// 아무곳에서 사용 가능하다.
		long temp = 1;
		for(int i = 1; i<=b; i++){
			temp *= a;
		}
		return temp;
	}
	%>
	
</body>
</html>