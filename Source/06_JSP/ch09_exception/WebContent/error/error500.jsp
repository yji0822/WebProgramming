<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

	<%@ page isErrorPage="true" %> <!-- exception 내부 객체를 사용하기 위함 -->
  <%response.setStatus(200); %> <!-- 다양한 웹브라우저가 있는데 안정성을 위하여 작성 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h2>공사중입니다. 빠른 시일 내로 복구하겠습니다. (error 500)</h2>
	<h4>관리자 문의 : hong@hong.com</h4>

<%
	System.out.println(exception.getMessage());
  System.out.println(exception.getClass().getName());
%>

</body>
</html>