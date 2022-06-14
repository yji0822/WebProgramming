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

	<!-- 브라우저가 닫기 전까지 유효한 세션 request scope 새로운 요청이 들어오기 전까지 -->
	<form action="ex02_scope.jsp">
	 	<p>이름 : <input type="text" name="name"></p>
		<p>id : <input type="text" name="id"></p>
		<p>비번 : <input type="text" name="pw"></p>
		<p><input type="submit"></p>
	</form>
	
	<%
	// 내장객체를 대체하는 EL
		pageContext.setAttribute("pageName", "pageValue"); 
	// 새로운 페이지가 들어오기 전까지 / 새로운 url창이 들어온다면 request객체는 사라지게 된다. - forward를 사용하면 안사라짐!
		request.setAttribute("requestName", "requestValue"); // 새로운 요청이 들어오기 전까지
		session.setAttribute("sessionName", "sessionValue"); // 세션이 만료되기 전까지
		application.setAttribute("applicationName", "applicationValue"); // 메모리에서 애플리케이션이 사라지기 전까지 (톰캣이 꺼지기 전까지)
	
		/*JAVA 안에어 forward 하는 방법 (forward 할 객체 : dispatcher) : jsp:forward 와 동일하게 하는 방법*/
/* 		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp"); */
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa&pw=111");
		// forward해라 하면 파라미터 값들을 가지고 ex02_scope 페이지로 넘어가게 해준다.
		dispatcher.forward(request, response); // request에 setAttribute한 것을 인식하게 해준다.
		/* request 값이 그대로 넘어오는지 확인*/
		
	%>
	
	<!-- forward의 위치는 setAttribute 밑에 작성해주도록 한다. 
	/ url주소창이 바뀌지 않아서 새로운 request객체가 만들어지지 않는다. -->
	<%-- <jsp:forward page="ex02_scope.jsp"/> --%>
	
	<h3>page 내 속성 변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 속성 변수 값 : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 속성 변수 값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 속성 변수 값 : <%=application.getAttribute("applicationName") %></h3>
	
	<hr>

	<h3>page 내 속성 변수 값 : ${pageScope.pageName }</h3>
	<h3>request 내 속성 변수 값 : ${requestScope.requestName } </h3>
	<h3>session 내 속성 변수 값 : ${sessionScope.sessionName }</h3>
	<h3>application 내 속성 변수 값 : ${applicationScope.applicationName }</h3>
	
	<hr>
	<!-- request,session에만 setAttribute만 할 예정 : 이름을 다른 이름으로 넣어주도록 한다. -->
	<!-- scope가 생략이 가능하다 -->
	<h3>page 내 속성 변수 값 : ${pageName }</h3>
	<h3>request 내 속성 변수 값 : ${requestName } </h3>
	<h3>session 내 속성 변수 값 : ${sessionName }</h3>
	<h3>application 내 속성 변수 값 : ${applicationName }</h3>

	
</body>
</html>