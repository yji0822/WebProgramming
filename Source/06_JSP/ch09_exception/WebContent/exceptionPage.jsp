<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>
<%@ page isErrorPage ="true" %> <!-- 지시자 : 관리자 모드로 들어가서 확인 할 수 있도록 에러페이지라고 명시 -->
<% response.setStatus(200); %> 
<!-- 200       : 정상 상태
		 500 error : 문법 오류나 예외 사항이 발생한 경우
		 400 error : 해당 문서를 찾을 수 없을 때
		 407 error : 인증을 받지 못한 경우 (잘 안나온다)
		  어떠한 상태인지 모르기 때문에 200으로 상태를 받도록 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		// 관리자만 콘솔창에서 확인할 수 있도록 하는 것
		console.log('예외메세지 : ' + '<%=exception.getMessage()%>');
		console.log('예외 타입 : ' + '<%=exception.getClass().getName()%>');
	</script>
</head>

<body>

	<h1>공사 중입니다. 0으로 나누는 부분은 아직 처리되지 않았습니다.</h1>
	<h6>문의 주시면 감사하겠습니다. mail 주소 추가</h6>

<%
	System.out.println("예외메세지 : " + exception.getMessage());
	System.out.println("예외 타입: " + exception.getClass().getName());
%>
</body>
</html>