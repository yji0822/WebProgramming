<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
		td{
			padding: 10px;
		}
	</style>
<body>
	<%
	// 스트링으로 받아지니 무조건 형변환!
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%= su1 %>단부터 <%=su2 %>단까지 구구단 출력</h3>
	
	<table>
	<% for(int i =1; i<=9; i++) { %>
		<!-- 3*1=3 4*1=4 ... -->	
		<tr>
			<% for(int j = su1; j<=su2; j++) {%>
				<td> <%=j %>*<%=i %>=<%=i*j %></td>
			<%} %>
		</tr>
	<% }%>
	</table>
		<br/><br/>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="history.go(-1)">뒤 로 가 기</button>
	<!-- 따옴표 꼭 주의해서 보자!!!! ** location은 많이 쓰인다 ** -->
	<button onclick="location.href='ex06_su2Input.jsp'">새로하기</button>
	
</body>
</html>