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

	<h2>표현식() 태그 이용</h2>

	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %></p> 
	<!-- 0.000000000000000000001 로 나눈 것과 같다(무한대) 0으로 나누게 되면 에러 발생 -->

	<p>관계연산 : 1 == 2 >> <%=1==2 %></p>
	<p>관계연산 : 1 != 2 >> <%=1!=2 %></p>
	<p>관계연산 : 1 &lt; 2  >> <%=1<2%></p>

	<p>조건연산 : <%= (1 > 2) ? "1이 2보다 큽니다." : "1이 2보다 크지 않습니다." %></p>

	<p>논리연산 : (1>2) || (1<2) = <%= (1>2) || (1<2) %></p>

	<p>로그인 여부 <%=session.getAttribute("customer") == null? "로그인 전" : "로그인 후" %></p>
	<p>로그인 여부 <%=session.getAttribute("customer") != null? "로그인 후" : "로그인 전" %></p>
	
	<p>pageNum 파라미터 여부 <%=request.getParameter("pageNum") == null ? "pageNum 안 넘어옴" : "pageNum 넘어 옴" %></p>
	<p>name 파라미터 : <%=request.getParameter("name")%> <!-- 여기서 먼저 실행하면 당연히 에러 발생(넘어온 값이 없음) -->
	<p>name 파라미터를 대문자로 : <%=request.getParameter("name").toUpperCase() %> 
	
	
	<h2>EL표기법을 이용 (표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<!-- 연산자나 session.getAttribute 모두 사용가능 -->
	<!--  null 값이 들어간 것도 에러가 발생되지 않는다. ex.name -->
	
	<!-- 스페이스 하나 정도 공백을 남겨놓고 만들어준다. -->
	<p>산술연산 : 10+1 = ${10+1 }</p>
	<p>산술연산 : 10/0.0 = ${10/0.0 }</p> 
	<!-- 0.000000000000000000001 로 나눈 것과 같다(무한대) 0으로 나누게 되면 에러 발생 -->

	<%-- <p>관계연산 : 1 == 2 => ${1==2 }</p> --%>
	<p>관계연산 : 1 == 2 => ${1 eq 2 }</p>
	<p>관계연산 : 1 != 2 => ${1!=2 }</p>
	<p>관계연산 : 1 &lt; 2 => ${1<2 }</p>

	<p>조건연산 : ${(1>2)? "1이 2보다 큽니다." : "1이 2보다 크지 않습니다." }</p>

	<p>논리연산 : (1>2) || (1<2) = ${(1>2) || (1<2) }</p>

	<p>로그인 여부 ${customer == null ? "로그인 전" : "로그인 후" }</p>
	<p>로그인 여부 ${customer eq null ? "로그인 전" : "로그인 후" }</p> <!-- not eq는 존재하지 않는다. -->
	<p>로그인 여부 ${empty customer? "로그인 전" : "로그인 후" }</p> <!-- 빈스트링이냐 아니냐	 -->
	<p>로그인 여부 ${not empty customer ? "로그인 후" : "로그인 전" }</p>
	<!-- session은 스크립트릿 내에서만 사용할 수 있는 내장 객체 -->
	
	<!-- EL내에서만 사용할 수있는 param -->
	<p>pageNum 파라미터 여부 ${empty param.pageNum ? "pageNum 안 넘어옴" : "pageNum 넘어 옴" }</p>
	<p>name 파라미터 : ${param.name } </p>
	<p>name 파라미터를 대문자로 : ${param.name.toUpperCase() } </p>
	<!-- 해당 파라미터가 없어도 예외가 발생되지 않는다. -->



</body>
</html>