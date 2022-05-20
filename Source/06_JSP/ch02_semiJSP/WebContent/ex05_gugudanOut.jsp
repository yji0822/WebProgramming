<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 무조건 String으로 들어가게 된다. -->
<%
	// request는 내장객체이다! request이용하여 받은 파라미터 값은 String (js 에서 document 같은!)
	// http://localhost:8090/ch02_semiJSP/ex05_gugudanOut.jsp?su=5
	int su = Integer.parseInt(request.getParameter("su"));
	// 파라미터를 안받아왔기 때문에 null값이 들어가있고(500내부서버오류 발생), 
	// 수 파라미터를 받아와야 하므로 ex05_dansuInput에서 실행을 해주거나 ~.jsp?su=3 이렇게 주소창에 입력을 해준다.
%>
	<h3>전달받은 파라미터 su값은 <%=su %>단 구구단 출력</h3>
	<%for(int i = 1; i<=9; i++){ %>
		<p><%=su %> * <%=i %> = <%=su*i %></p>
	<%} %>
</body>
</html>