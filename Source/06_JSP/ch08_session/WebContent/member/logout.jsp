<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap {
			width:430px;
			margin: 0 auto;
			height: 600px;
			line-height: 600px;
			text-align: center;
			font-weight: bold;
		}
	</style>
	<script>
		alert("로그아웃 되었습니다.");
		setTimeout(function(){
			location.href = "<%=conPath%>/member/main.jsp";
		}, 2000);
	</script>
	
</head>
<body>

	<%
/* 		Cookie[] cs = request.getCookies();
		if(cs!=null) {
			for(Cookie c : cs) {
				if(c.getName().equals("id")){
					c.setMaxAge(0);
					response.addCookie(c);
					break;
				} // if
			} // for
		} // if */
		
		String name = (String)session.getAttribute("name");
		if(name!=null) {
			session.invalidate();
		
		}
		
	%>

<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		로그아웃 되었습니다. 잠시 후 페이지 이동이 있겠습니다.
	</div>
	<jsp:include page="footer.jsp"/>

</body>
</html>