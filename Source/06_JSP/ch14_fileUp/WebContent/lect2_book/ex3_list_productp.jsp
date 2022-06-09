<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
	
		<table>
			<tr>
	<%
		// paging 추가 : PAGESIZE = 3, BLOCKSIZE = 4
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE = 4;
		int startRow = (currentPage-1) * PAGESIZE + 1; // 현재 블록의 첫번째 페이지
		int endRow = startRow + PAGESIZE - 1; // 현재 블록의 마지막 페이지
	
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow); /***반드시!!!****/
		
		// 확장for문 이용하면 안된다 - 3개만 출력하고 다음 줄로 넘어가도록 해야하기 때문이다. 012 하고 td닫고 td열고
		for(int i=0; i<books.size(); i++) {
	%>
			<!-- td까지만 써줬을때는 한줄에 모든 리스트가 출력이 된다. -->
			<td>	
				<!-- 배열의 이미지를 받아오는 것 -->

			<!-- ** 상세보기 페이지 : bid와 pageNum을 가지고 넘어가야 한다. -->
			<!-- pageNum이 존재하지 않는다면 1페이지로 넘어가게 하는 로직도 있다! -->
			<a href="ex4_detail.jsp?bid=<%=books.get(i).getBid()%>&pageNum=<%=pageNum%>">				
				<img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
				<%=books.get(i).getBtitle() %><br>
			</a>	
				
				<del><%=books.get(i).getBprice() %></del><br>
				(<%=books.get(i).getBdiscount() %> %할인) <br>
				<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
			</td>
			
			<!-- 분할해주는 작업 : PAGESIZE를 3으로 설정을 해놨기 때문에 적어주지 않아도 된다.-->
			<%-- <%if(i%3==2) out.println("</tr><tr>"); //3개가 한줄 출력 %> --%>
	<%}%>
	</tr>
	</table>
	
	<div class="paging">
	<%
		int bookTotalCnt = bDao.getBookTotCnt(); // 북 전체 페이지 받아오는 것
		int pageCnt = (int)Math.ceil((double)bookTotalCnt/PAGESIZE);
		
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE) {
		%>
			[<a href="ex3_list_productp.jsp?pageNum=<%=startPage-1 %>"> 이전블록 </a>]
		<%}
			
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) {
				out.println("[ <b> " + i + "</b> ]");
		} else {
			out.println("[ <a href='ex3_list_productp.jsp?pageNum=" + i + "'>" + i +"</a> ]");
		}
	} 
		if(endPage<pageCnt) {
			%>
			[ <a href="ex3_list_productp.jsp?pageNum=<%=endPage+1 %>">다음</a> ]
	<%}	%>
	</div>

</body>
</html>