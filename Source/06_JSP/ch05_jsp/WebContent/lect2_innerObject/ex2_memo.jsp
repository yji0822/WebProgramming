<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %> 
<!-- /project_name -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<!-- <link href="/ch05_jsp"> -->
	<link href="<%=conPath %>/css/ex2.css" rel="stylesheet">
	<!--  java소스는 java 소스에 넣고.... 무조건 링크는 conPath를 이용하여 사용할 예정 -->	
</head>
<body>
	<!--  request.contextpath 를 알기 때문에 더이상 루트를 찾아 헤매이지 않아도 된다. -->
	<!-- 이름 입력, 한줄메모 입력 다음 줄에 submit버튼 -->
	<form action="ex2_memoPro.jsp" method="post">
		<!-- 한줄메모가 길어질 수도 있기 때문에 post 방식으로 받는다 -->
		<table>
			<tr>
				<th>작성자</th>
				<th>한줄메모</th>
			</tr>
			<tr>
				<td><input type="text" name="writer" size="3"></td>
				<td><input type="text" name="memo" size="30"></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="메모작성"></td></tr>
		</table>
	</form>
</body>
</html>