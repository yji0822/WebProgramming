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
	<h2>모든 요청에서 cnt, list 출력 가능</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list }</h3>
	
	<h2>result1.jsp 페이지에서 넘어온 개인 정보</h2>
	<h4>name : ${name }</h4>
	<h4>id : ${id }</h4>
	<h4>pw : ${pw }</h4>
	<h4>age : ${age }</h4>
	<h4>email : ${email }</h4>
	<h4>address : ${address }</h4>
	
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath }/'">처음으로</button>
</body>
</html>