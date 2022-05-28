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

	<!-- step4에서 만든 p객체를 뿌려주는 작업 - 뷰 단!
		프로세스 단에서 만든 것을 뿌려주는 작업	 -->
	<!-- 동일하게 빈을 생성해주면 step4에서 적어준 것을 받아올 수 있다. -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="p"/></p>
	<p>나이 : <jsp:getProperty property="age" name="p"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="p"/></p>
	<p>주소 : <jsp:getProperty property="address" name="p"/></p>

</body>
</html>