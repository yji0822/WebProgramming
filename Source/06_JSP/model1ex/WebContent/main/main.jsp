<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
		// 실행할때 main.jsp or main.jsp?pageNum=3 or main.jsp?pageNum=1 
		// 회원정보를 수정할건데 페이징 작업
		String pageNum = request.getParameter("pageNum");
		
	if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum); // startPage endPage 설정 가능
		final int PAGESIZE = 5, BLOCKSIZE = 2;
		int startRow = (currentPage -1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		
		CustomerDao cDao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
	%>
	
	<table>

		<tr style="height:60px;">
			<th>회원id</th><th>비밀번호</th><th>이름</th><th>메일</th><th>주소</th>
		</tr>
		<!-- customers 받은 내용들 출력하는 로직 -->
		<% if(customers.size() == 0) { %>
			<tr>
				<td colspan="5"> 해당 회원이 없습니다.</td>
			</tr>
		<%} else {
				for(CustomerDto c : customers) {
					out.println("<tr style='height:60px;'><td>" + c.getCid() + "</td>");
					out.println("<td>" + c.getCpw() + "</td><td>" + c.getCname() + "</td>");
					out.println("<td>" + (c.getCemail()!= null? c.getCemail() : "-") + "</td><td>" 
																+ (c.getCaddress()!=null? c.getCaddress() : "") + "</td></tr>");
					// null이 들어갈 수도 있는 경우가 있으므로 받아오는 곳에서 바로 처리를 해준다.
				}
		} %>	

	</table>
	
	<div class="paging"></div>
		<%
			int totCnt = cDao.getCustomerCnt(); // 회원 수
			int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			
			if(endPage > pageCnt) {
				endPage = pageCnt;
			}
			// 이전 블록이 있는지 없는지
			if(startPage > BLOCKSIZE) {
		%>	
			[ <a href ="<%=conPath %>/main/main.jsp?pageNum=<%=startPage-1 %>">이전</a> ]	
		<% }
			for(int i=startPage ; i<=endPage ; i++) {
				if(i == currentPage) {
					out.println("[ <b>" + i + "</b> ] ");
				} else {
					out.println("[ <a href='" + conPath +"/main/main.jsp?pageNum=" +i+"'>"+i+"</a> ]");
				}
			}
			if(endPage<pageCnt) {
				%>
					[ <a href ="<%=conPath %>/main/main.jsp?pageNum=<%=endPage+1 %>">다음</a> ]	
	<% }%>
		
	</div>
	
	<jsp:include page="../main/footer.jsp"/>
	

</body>
</html>