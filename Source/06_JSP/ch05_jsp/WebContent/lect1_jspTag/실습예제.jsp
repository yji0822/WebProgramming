<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		fieldset {
			width: 400px;
			margin: 0 auto;
		}
		h1 {
			text-align: center;
		}
	</style>
</head>
<body>
	<% String num = request.getParameter("num"); // null(처음실행)이거나 숫자 스트링이거나 %>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" method="get">
			숫자 <input type="number" name="num" value="<% if(num!=null) out.print(num); %>">
			<!-- num이 null이 아닐때만 value 값이 들어오도록 -->
			<input type="submit" value="누적">
		</form>
	</fieldset>
	
	<%
	if(num != null && !num.equals("")) {
		int n = Integer.parseInt(num);
		int total = 0; // 누적변수
		for(int i=1; i<=n; i++){
			total += i;
	} 
	out.println("<h1>1부터 " + n + "까지의 누적합은 " + total + "입니다.</h1>");
	} //if-else
%>
</body>
</html>