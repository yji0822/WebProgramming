<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<!-- param은 input에서 가져온 parameter 값이다. -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty name="p" property="name" param="name"/>	
	<jsp:setProperty name="p" property="age" param="age"/>
	<jsp:setProperty name="p" property="gender" param="gender" />
	<jsp:setProperty name="p" property="address" param="address"/>
	<!-- 알아서 숫자랑 문자로 받아들어와서 저장된다 -->
	<jsp:forward page="pVeiw.jsp"/>
</body>
</html>