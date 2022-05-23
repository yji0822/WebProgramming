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
		// 스크립트릿
		int j; // 반드시 초기화를 해주어야 한다 (쓰레기 값이 들어가 있는 상태)
		j = 0;
		i++; // i는 선언부에 있기 때문에 어디에든 써주어도 상관 없다.
		j++;
		strBuf.append("<span>☆</span>");
	%>
	전역변수 i = <%= i %><br>
	지역변수 j = <%= j %><br>
	strBuf = <%=strBuf %>
	
	<%
	out.println("<br>strBuf = " + strBuf + "<br>");
	out.println("sum(5,2) = " + sum(5,2));
	%>
	
	<%!
	// 선언부는 보통 위에다 놓는다. - 변수만 봐도 어떤 일을 하는지 파악 가능한 장점
		int i; // 선언부에 선언한 변수 - 초기화가 자동으로 된다 (숫자는 0)
		StringBuffer strBuf = new StringBuffer("Good");
		
		public int sum(int a, int b) {
			return a + b;
		}
	%>
</body>
</html>