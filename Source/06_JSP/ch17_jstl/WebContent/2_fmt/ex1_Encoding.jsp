<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

	<!-- fmt 태그 사용하여 utf-8 변환. 한글 깨지지 않도록 
	자바에서 setCharacterEncoding을 해주기 때문에 많이 사용하지는 않는다.-->
	
	<fmt:requestEncoding value="utf-8"/>
	<h1> 이름 (EL) : ${param.name }</h1>	
	
	<%-- <% request.setCharacterEncoding("utf-8"); %>
	<h1> 이름 (지시자) : <%=request.getParameter("name") %></h1> --%>	
	
</body>
</html>