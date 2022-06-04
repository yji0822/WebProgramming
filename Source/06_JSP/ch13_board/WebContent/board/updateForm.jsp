<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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

	<%
		String num = request.getParameter("num");
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.getBoardOneLine(num);
	%>
	<!-- 글번호가 반드시 넘어와야지만 수정이 가능하다 -->
	<form action="updatePro.jsp" method="post"> <!-- 반드시 hidden으로 값 넘어오도록 -->
	<input type="hidden" name="num" value="<%=num %>">
		<table>
			<caption><%=num %>번 글 수정</caption>
			<!-- 작성자 수정 불가 -->
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%= dto.getWriter() %>" readonly="readonly"></td>
				<%-- <td><%= dto.getWriter() %></td> --%>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="<%= dto.getSubject() %>" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" 
										value="<%=dto.getEmail()!= null? dto.getEmail(): "" %>" ></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="5" name="content"
								required="required"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" value="<%= dto.getPw() %>" required="required"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="locatoin.href='list.jsp'">
 				</td>
			</tr>
		</table>
	</form>

</body>
</html>