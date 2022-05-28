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
	<!-- step4 -->
	<!-- 프로세스 단계만 객체 만들어서 파라미터에 넣는 작업 -->
	<!-- session 브라우저 닫기 전까지.. scope="request" 로 꼭 바꿔주기step4.jsp-->
	<jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
	<jsp:setProperty name="p" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty name="p" property="age" value="<%=Integer.parseInt(request.getParameter(\"age\")) %>"/>	
	<jsp:setProperty name="p" property="gender" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty name="p" property="address" value='<%=request.getParameter("address") %>'/>
	
	<jsp:forward page="pVeiw.jsp"></jsp:forward>
	<!--  forward하면 주소창이 바뀌지 않는다. -->
	
</body>
</html>