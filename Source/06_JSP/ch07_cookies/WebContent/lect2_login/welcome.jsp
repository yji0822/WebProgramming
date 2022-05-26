<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- 스타일 적용 -->
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

	<%
		String id   = null;
		String name = null;
		Cookie[] cs = request.getCookies(); // 쿠키를 배열로 받아옴
		if(cs!= null) {
			for(int i = 0; i<cs.length; i++){
			// id,name 쿠키가 있는지 확인 (총 두번 확인)
				if(cs[i].getName().equals("id")){
					id = cs[i].getValue();
				} else if(cs[i].getName().equals("name")){
					name = cs[i].getValue();
				}
			} // for - 로그인 후: id변수에 로그인한 id가, name변수엔 로그인한 name이 할당
				//	           로그인 전 : id변수와 name 변수엔 null 값
		} // if
	%>
	<% if(name!=null) { // 로그인 후 화면 %>
			<h1><%=name %>(<%=id %>)님 반갑습니다!</h1>
			<button onclick = "location.href='logout.jsp'">로그아웃</button>
			<button onclick = "location.href='cookielist.jsp'"> 쿠키들 확인 </button>
		<% } else { // 로그인 전 화면 %>
			<h1>손님(guest) 반갑습니다. 로그인 하세요.</h1>
			<button onclick="location.href='login.html'">로그인</button>
			<button onclick = "location.href='cookielist.jsp'"> 쿠키들 확인 </button>
		<% }%>

</body>
</html>