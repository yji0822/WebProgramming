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
	<!-- 페이징을 추가한 책 리스트 
	ex3_list_boardP.jsp 또는 ex3_list_boardp.jsp?pageNum=1 또는 ex3_list_boardp.jsp?pageNum=5 가 출력될 수 있도록
	-->
	<%
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=3, BLOCKSIZE=4;
		int startRow = (currentPage-1) * PAGESIZE + 1; // 시작페이지
		int endRow = startRow + PAGESIZE -1; // 마지막 페이지 
	
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	%>
	
	<table>
		
		<caption>책 리스트</caption>

		<tr>
			<th>책ID</th>
			<th>책이름</th>
			<th>책대표이미지</th>
			<th>가격</th>
			<th>할인율</th>
			
			<% if(books.size() == 0) {
				out.println("<tr><td colsapn='5'>등록된 책이 없습니다.</td></tr>");
			}else {
				// 몇개 있는지 모르니까 for문 사용
				for(BookDto book : books) {
					out.println("<tr><td>" + book.getBid() + "</td><td>" + book.getBtitle() + "</td>");
					out.println("<td><img src='../bookImg/" + book.getBimage1() + "' width='15'></td>");
					out.println("<td>" + book.getBprice() + "</td><td>" + book.getBdiscount() + "</td></tr>");
				}
			}
			%>
			
			<!-- 실행을 할때 이미지가 받아져오지 않는다면 bookImg 폴더를 누르고 새로고침을 진행 한 뒤에 다시 실행해보기! -->
			
		</tr>
	</table>
	
	<!-- 페이지 넘어갈 수 있게 만들어주는 로직 -->
	<div class="paging">
	<%
		int bookTotalCnt = bDao.getBookTotCnt(); // 전체 개수
		int pageCnt = (int)Math.ceil((double)bookTotalCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1; // 현재페이지리스트 블럭의 맨 첫번째 페이지
		int endPage = startPage + BLOCKSIZE - 1; // 현재 페이지 블럭의 맨 마지막 페이지
		
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE) {
	%>
		[<a href="ex3_list_boardp.jsp?pageNum=<%=startPage-1%>"> 이전 블록 </a>]
	<%}
		
		for(int i=startPage ; i<=endPage ; i++) {
			if(i==currentPage) {
				out.println("[ <b> "+ i + " </b> ]" );
			} else {
				out.println("[ <a href='ex3_list_boardp.jsp?pageNum=" + i + "'>" + i + "</a> ]");
			}
		}
		
		if(endPage<pageCnt) { 
		%>
			[ <a href="ex3_list_boardp.jsp?pageNum=<%=endPage+1 %>">다음</a> ] 
	<%}	%>
	
	
	</div>

</body>
</html>