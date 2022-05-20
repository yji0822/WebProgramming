<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	window.onload = function(){
		
		document.querySelector('form').onsubmit = function(){
			var name = document.querySelector('input[name="name"]'); 
			var id = document.querySelector('input[name="id"]');
			var password = document.querySelector('input[name="password"]');
		}
		
	};
	</script>
</head>
<body>
	<h3>로그인 화면</h3>
	<form action="ex07_result.jsp" method="post">
		<table>
			<tr>
				<td>이름 <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>아이디<input type="text" name="id"></td>
			</tr>
			<tr>
				<td>패스워드 <input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>