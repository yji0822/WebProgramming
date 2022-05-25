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
				var opt = document.querySelectorAll('option');
				var cnt = 0;
				for(var i=0; i<opt.length; i++) {
					cnt = cnt + opt[i].selected;
				}
				if(!cnt) {
					alert('구구단 한개 이상은 선택하셔야 합니다.');
					return false;
				}
			};
		};
	</script>
</head>
<body>
	<form action="">
		<select name="su" multiple="multiple" size="5">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7">7단</option>
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
		<br>
		<input type="submit" value="선택완료">
	</form>	
</body>
</html>