<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>로그인 화면</h3>
	<form action="home07_result.jsp" method="get">
	<table>
	<tr>
	<td>
	이름 <input type="text" name="name">
	</td>
	</tr>
	
	<tr>
	<td>
	아이디 <input type="text" name="id">
	</td>
	</tr>
	
	<tr>
	<td>
	비밀번호 <input type="password" name="pw">
	</td>
	</tr>
		
	<tr>
	<td colspan="2">
	<input type="submit" value="로그인">
	</td>
	</tr>
	
	</table>	
	</form> 	
</body>
</html>