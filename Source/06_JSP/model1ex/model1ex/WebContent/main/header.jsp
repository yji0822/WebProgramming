<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>

<body>
	<!-- css와 비교해서 보기 -->
	<!--  .gnb(로그인 전/로그인 후) - .logo - .lnb(도서보기, 도서등록(로그인 후)) -->
	
	<header>
		
		<div class="gnb">
		<!-- 로그인 전과 후의 메뉴가 달라지는 gnb -->
			<%
				if(session.getAttribute("customer") == null) {
					// 로그인 전. customer의 정보가 담긴 session이 없다 %>
					<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->
					<ul>
						<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
						<li><a href="<%=conPath %>/customer/joinForm.jsp">회원가입</a></li>
						<li><a href="<%=conPath %>/customer/loginForm.jsp">로그인</a></li>
					</ul>
			<%} else { %>
					<!-- 로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보수정, 고객이름 -->
					<!-- 고객센터를 누르면 파일첨부 게시판으로 넘어가도록 -->
					<ul>
						<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
						<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a></li>
						<li><a href="<%=conPath %>/customer/modifyForm.jsp">정보수정</a></li>
						<li><a href="#"><%=((CustomerDto)session.getAttribute("customer")).getCname() %></a>
					</ul>
			<%} %>
		</div>
		
		<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
			<img src = "https://www.moel.go.kr/images/layout/img_footer_logo.png">		
		</div>
		
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인 후) -->
			<ul>
				<!-- 로그인을 안해도 볼 수 있는 도서보기 -->
				<li><a href="<%=conPath %>/book/booklist.jsp">도서보기</a></li>
				<!-- 세션으로 customer 속성이 들어와있는지 확인한 후에 메뉴 보여주는 방식 -->
				<% if(session.getAttribute("customer") != null) {%>
					<li><a href="<%=conPath %>/book/bookRegister.jsp">도서등록</a></li>
				<%} %>
			</ul>
		</div>	
		
	</header>

</body>
</html>