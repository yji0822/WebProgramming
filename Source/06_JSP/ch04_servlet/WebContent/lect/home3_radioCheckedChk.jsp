<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		window.onload = function() {
			document.querySelector('form').onsubmit = function() {
				var agreeYes = document.querySelector('input[name="agree"]');
				if(!agreeYes.checked) {
					alert('동의하셔야 다음으로 넘어갑니다.');
					return false;
				} //if
			};
		};
	</script>
</head>
<body>
	<fieldset>
		<legend>이용 약관</legend>
		회원가입 약관들 들어가는 곳 입니다ㅏㅏㅏㅏㅏㅏㅏ
	</fieldset>	
	<form action="">
		<input type="radio" name="agree" value="agree">동의
		<input type="radio" name="agree" value="disagree">비동의
		<br/>
		<input type="submit" value="next">
	</form>
</body>
</html>