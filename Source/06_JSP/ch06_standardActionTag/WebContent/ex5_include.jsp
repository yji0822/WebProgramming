<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link href="<%= conPath %>" rel="stylesheet" type="text/css">
	
</head>
<body>
	<h1>ex5_include.jsp 페이지 입니다.</h1>
	<h2>반갑습니다.</h2>
	
	<!-- include 2가지 방법 : 차이점 확인-->
	<%-- <%@ include file="includePage.jsp" %> --%> <!-- 파일 원본 그대로를 include -->
	<!-- conPath가 include한 파일에 있기 때문에 변수가 겹쳐서 에러가 발생된다 > includePage.jsp의 conPath를 주석처리
	정상적으로 작동되는 듯 싶지만.. includePage.jsp만 실행했을 경우에는 에러가 발생된다.-->
	<h1>다시 ex5_include.jsp (%@include file)페이지입니다</h1>
	
	<!-- 이 방법을 더 많이 사용한다. -->
	<jsp:include page="includePage.jsp"/> <!-- jsp 파일의 결과를 include한다. (html로 만든 그 결과를) -->
	<h1>다시 ex5_include.jsp 페이지입니다 (jsp:include page="includePage.jsp")</h1>

</body>
</html>