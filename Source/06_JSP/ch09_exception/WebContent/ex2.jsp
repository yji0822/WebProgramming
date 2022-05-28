<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h2>web.xml을 이용한 예외 페이지 처리</h2>
	<a href="xx.html">없는 파일을 클릭하면 404에러</a>
	
	<%
		// 숫자형 param이란 변수가 없는데 파라미터를 받아오라는 500에러 - NumberFormatException
		int param = Integer.parseInt(request.getParameter("param")); // 주석을 풀면 Array~ 에러로 바로 떨어지고
		int[] arr = {10, 20, 30};
		// < 대신 <= 로 부등호를 바꾸어서 500 에러 발생 - ArrayIndexOutofBoundsException
		for(int i=0; i<=arr.length; i++) {
			out.print(arr[i] + ",");
		}
	%>

</body>
</html>