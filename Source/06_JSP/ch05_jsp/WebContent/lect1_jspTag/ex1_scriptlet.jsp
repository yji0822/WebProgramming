<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 어디서도 사용 가능한 스크립트릿 -->
<% 
	// response는 사용할 일이 거의 없다.
	// 위에서 받은 color
	String color = request.getParameter("color");
	if(color == null) {
		color = "white";
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body {
			background-color: <%= color %>;
			/* 색을 모른다면 css는 무시를 하기 때문에 바뀌지 않는다. */
		}
	</style>
</head>

<body>
	<h1>배경색 바꾸기</h1>
	<form action="">
		<select name="color">
			<option value="red">빨강</option>
			<option value="orange">오렌지</option>
			<option value="yellow">노랑</option>
			<option value="green">초록</option>
			<option value="blue">파랑</option>
			<option value="navy">남색</option>
			<option value="purple">보라</option>
		</select>
		<input type="submit" value="적용">
	</form>
</body>
</html>