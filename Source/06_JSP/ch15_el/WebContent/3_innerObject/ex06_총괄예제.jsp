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

	<form>
		<input type="number" name="n1" value="<%=(int)(Math.random()*9)+1%>"> * 
		<input type="number" name="n2" value="<%=(int)(Math.random()*9)+1%>"> = 
		<input type="number" name="result">
		<br>
		<input type="submit" value="확인">
	</form>	
	
	<%-- <h2>
	${param.n1 } * ${param.n2 } = ${param.result }
	${param.result eq param.n1*param.n2 ? "는 true" : "는 false" }
	</h2> --%>
	
	<h2>
	${param.n1 } * ${param.n2 } = ${param.result }
	${param.n1 * param.n2 eq param.result }
	${not empty param.result ? (param.n1 * param.n2 eq param.result ? "정답" : "오답") : "" }
	</h2>


</body>
</html>