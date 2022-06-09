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
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook();
		
		// 확장for문 이용하면 안된다 - 3개만 출력하고 다음 줄로 넘어가도록 해야하기 때문이다. 012 하고 td닫고 td열고
		for(int i=0; i<books.size(); i++) {
	%>
			<!-- td까지만 써줬을때는 한줄에 모든 리스트가 출력이 된다. -->
			<td>	
				<!-- 배열의 이미지를 받아오는 것 -->
				<img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
				<%=books.get(i).getBtitle() %><br>
				<del><%=books.get(i).getBprice() %></del><br>
				(<%=books.get(i).getBdiscount() %> %할인) <br>
				<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
			</td>
			
			<!-- 분할해주는 작업 -->
			<%if(i%3==2) out.println("</tr><tr>"); //3개가 한줄 출력 %>
	<%}%>
	
	</table>

</body>
</html>