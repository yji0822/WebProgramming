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
		// 반드시 list.jsp에서 실행할 수 있도록 한다. 
		/* num이랑 pageNum을 가지고 있는 content.jsp */
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");	
	
		BoardDao dao = BoardDao.getInstance();
		dao.readcountUp(num); // hit수 up
		BoardDto dto = dao.getBoardOneLine(num);
	%>
	
	<table>
		<caption><%=dto.getNum() %>번 글 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td><%=dto.getNum() %></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getEmail() != null ? dto.getEmail() : "-" %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getReadcount() %></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><%=dto.getContent() %></td>
		</tr>
		<tr>
			<th>아이피주소</th>
			<td><%=dto.getIp() %></td>
		</tr>
		<tr>
			<th>글쓴시점</th>
			<td><%=dto.getRdate() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- 페이지 번호를 모든 곳에 넘겨주도록 한다. -->
				<button onclick="location.href='updateForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">수정</button>
				<button onclick="location.href='deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">삭제</button>
				<button>답변</button>
				<button onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">목록</button>
			</td>
	</table>

</body>
</html>