<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		// submit을 안누르면 실행이 안된다! - while 사용할 이유가 없음
		// 유효성 검증
		window.onload = function(){
			document.querySelector('form').onsubmit = function(){
				var su1 = document.querySelector('input[name="su1"]'); // su1 받아오기
				var su2 = document.querySelector('input[name="su2"]');
				
				if(!su1.value) {
					alert('첫번째 수를 입력하세요');
					su1.focus();
					return false; // 디폴트 이벤트 제한
				} else if(!su2.value) {
					alert('두번째 수를 입력하세요.');
					su2.focus();
					return false; // 디폴트 이벤트 제한
				}
				// 형변환
				var s1 = Number(su1.value); // 절대 수1에 빈스트링이 안들어왔다!
				var s2 = Number(su2.value);
				
			
				if(s1>s2){
					alert('첫번째 숫자가 작거나 같은 수를 넣어주세요.');
					su1.value = '';
					su1.value = '';
					su1.focus();
					return false;
				}
			};
		};
	</script>

</head>
<body>
	<form action="ex06_guguOut.jsp" method="get">
	<!-- get방식 > url이 보이게 된다. 256문자까지만 입력이 된다. post방식도 있음! -->
	<!-- 수를 입력하지 않고 버튼을 눌러도 빈스트링으로 넘어가게 된다. 자바에서는 빈스트링은 에러발생! -->
		<p>
			단수 <input type="number" name="su1">
			<b>~</b>
			<input type="number" name="su2"> 단
		</p>
		<p>
			<input type="submit" value="원하는 구구단 출력">
		</p>
	</form>
</body>
</html>