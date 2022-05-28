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
	
	<!-- 변수의 범위 설정 X (이 페이지에서만 유효 : page) 반드시 생성자가 없는!! -->
	<!-- scope : default 값은 page : 현재 페이지에서만 값이 유용하다 -->
	<!-- scope="request" 새로운 request 객체가 만들어지기 전까지 사용 가능 -->

	<jsp:useBean class="com.lec.ex.Person" id="p" scope="page"/>
	<jsp:setProperty name="p" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty name="p" property="age" value="<%=Integer.parseInt(request.getParameter(\"age\")) %>"/>	
	<jsp:setProperty name="p" property="gender" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty name="p" property="address" value='<%=request.getParameter("address") %>'/>

	<!-- step3 : p 객체의 이름을 가져와봐! 자기가 알아서 getGender 호출-->
	<h2>입력받은 개인정보</h2>
	<p>이름 : <jsp:getProperty name="p" property="name"/></p>
	<p>나이 : <jsp:getProperty name="p" property="age"/></p>
	<p>성별 : <jsp:getProperty name="p" property="gender"/></p>
	<p>주소 : <jsp:getProperty name="p" property="address"/></p>
	
</body>
</html>