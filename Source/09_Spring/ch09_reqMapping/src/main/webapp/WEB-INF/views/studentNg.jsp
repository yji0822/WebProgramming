<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h2>studentNg 페이지</h2>
	<h2>redirect로 보내는 방식</h2>
	<h4>confirm에서 실패된 ID : ${param.id }(파라미터의 id o)</h4>
	<h4>confirm에서 실패된 id : ${id }</h4>	
	<!-- param으로 id를 받아오지 않는다면 redirect는 받아오지 않는다.  -->
</body>
</html>