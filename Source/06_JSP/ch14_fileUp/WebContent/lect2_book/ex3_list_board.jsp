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

	<%
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook();
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

</body>
</html>