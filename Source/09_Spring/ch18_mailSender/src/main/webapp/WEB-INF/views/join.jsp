<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>

<body>
	
	<!-- id랑 비밀번호만 입력받을 것 -->
	<form action="textMail">
		<p> 이름 <input type="text" name="name" required="required"></p>
		<!-- 내가 입력을 하면 실제로 메일을 받아야 할 실 주소 입력받을 것 -->
		<p> 메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입 (text 단순 메일 전송)">
		<!-- html이 전혀 적용되지 않고 단순 텍스트만 전송이 되는 것 -->
	</form>
	
	<hr color="red">
	
	<form action="htmlMail">
		<p> 이름 <input type="text" name="name" required="required"></p>
		<p> 메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입 (html 단순 메일 전송)">
	</form>
		
</body>
</html>