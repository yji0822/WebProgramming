<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>

	<h1>"현재 총 ${cnt }명"</h1>
	
	<form action="${conPath }/quizInputResult.do" method="post">
		<p> 개인 정보 입력 </p>
		<p> 이름 : <input type="text" name="name" value="${quiz.name }"></p>
		<p> 국어 : <input type="number" name="kor" placeholder="0~100" 					
					value='<c:if test="${quiz.kor!=0 }">${quiz.kor }</c:if>'></p>
		<p> 영어 : <input type="number" name="eng" placeholder="0~100" 					
					value='<c:if test="${quiz.eng!=0 }">${quiz.eng }</c:if>'></p>
		<p> 수학 : <input type="number" name="math" placeholder="0~100" 					
					value='<c:if test="${quiz.math!=0 }">${quiz.math }</c:if>'></p>	
		
		<input type="submit">
		
	</form>	
	<h4>${nameError }</h4>
	<h4>${scoreError }</h4>
	
</body>
</html>