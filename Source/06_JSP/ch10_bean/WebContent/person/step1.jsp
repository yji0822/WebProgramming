<%@page import="com.lec.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>

<!-- input.html 부터 실행하자 / request.getParameter에 값이 없어서 error발생 -->

<%
	Person p = new Person();
	p.setName(request.getParameter("name"));
	p.setAge(Integer.parseInt(request.getParameter("age")));
	p.setGender(request.getParameter("gender").charAt(0));
	p.setAddress(request.getParameter("address"));	
%>	

	<h2>입력받은 개인정보</h2>
	<p>이름 : <%= p.getName() %></p>
	<p>나이 : <%= p.getAge() %></p>
	<p>성별 : <%= p.getGender() %></p>
	<p>주소 : <%= p.getAddress() %></p>
	

</body>
</html>