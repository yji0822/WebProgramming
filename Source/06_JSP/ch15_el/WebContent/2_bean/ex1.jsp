<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<jsp:useBean id="member" class="com.lec.ex.Member"/>
	<jsp:setProperty property="*" name="member"/>
	
	<h2>bean 태그를 이용한 정보 출력</h2>
	<h3>이름 : <jsp:getProperty property="name" name="member"/></h3>
	<h3>아이디 : <jsp:getProperty property="id" name="member"/></h3>
	<h3>비밀번호 : <jsp:getProperty property="pw" name="member"/></h3>
	
	<h2>표현식을 이용한 정보 출력</h2>
	<h3>이름 : <%=member.getName() %></h3>
	<h3>아이디 : <%=member.getName() %></h3>
	<h3>비밀번호 : <%=member.getName() %></h3>
	
	<!-- getter를 찾아서 불러오는 EL -->
	<h2>EL표기법을 이용한 정보 출력</h2>
	<h3>이름 : ${member.name }</h3>
	<h3>아이디 : ${member.id }</h3>
	<h3>비밀번호 : ${member.pw }</h3>
	
</body>
</html>