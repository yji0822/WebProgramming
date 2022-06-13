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

	<jsp:include page="../main/header.jsp"/>

	<div id="content_form">
	
	<%
		String pageNum = request.getParameter("pageNum");
		String fnum = request.getParameter("fnum");
	%>
	<table>
		<caption><%=fnum %>번 글 삭제</caption>
		<tr>
			<td>
				<fieldset>
					<legend>삭제하기 위한 암호 입력</legend>
					<form action="fboardDeletePro.jsp" method="post">
						<input type="hidden" name="pageNum" value="<%=pageNum %>">					
						<input type="hidden" name="fnum" value="<%=fnum %>">
						<p>암호<input type="password" name="fpw" required="required" class="btn"></p>					
						<p>
							<input type="submit" value="삭제" class="btn">
							<!-- 초기화를 시킨 다음에 이전 페이지로 넘어가도록./... 
							글 상세 보기로 넘어가도록  해준다. button만 onclick 만 사용하는 것이 아니라 reset에도 사용이 가능하다 -->
							<input type="reset" value="삭제취소" onclick="history.back()" class="btn">
						</p>					
					</form>
				</fieldset>
			</td>
		</tr>
	</table>
	
	</div>
	
	<jsp:include page="../main/footer.jsp"/>

</body>
</html>