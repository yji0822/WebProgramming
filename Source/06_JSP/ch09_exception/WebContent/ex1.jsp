<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>
<%@ page errorPage="exceptionPage.jsp" %> <!-- 예외페이지로 들어가도록 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<!-- input.html에서 실행 -->
	<%! int num1, num2; %>
	<%
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("<h3> num1 = " + num1 + ", num2 = " + num2 + "</h3>");
		out.println("<h3> num1 + num2 = " + (num1+num2) + "</h3>");
		out.println("<h3> num1 / num2 = " + (num1/num2) + "</h3>");
		out.println("<h3> num1 - num2 = " + (num1-num2) + "</h3>");
		out.println("<h3> num1 * num2 = " + (num1*num2) + "</h3>");
		out.println("<h3>DONE</h3>");
	%>
	

</body>
</html>