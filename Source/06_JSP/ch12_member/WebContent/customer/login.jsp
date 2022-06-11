<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if(session.getAttribute("member")!=null){ // 로그인 상태
		response.sendRedirect("main.jsp");
	}
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/login.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<div id="loginForm_wrap">
		<div id="login_title">로그인</div>
		<form action="loginPro.jsp" method="post">
			<table>
				<tr><td> </td></tr>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" 
						required="required" autofocus="autofocus"
						value="<%
						String cid = (String)session.getAttribute("cid");
							if(cid!=null){
								out.print(cid);
							}
						%>"></td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" required="required"></td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr><td colspan="2"><input type="submit" value="로그인" 
								class="loginBtn_style"></td></tr>
				<tr>
					<td colspan="2">
						<%String msg = request.getParameter("msg");
							if(msg!=null){ %>
							<p id="login_findIdPw" onclick="alert('id=aaa / pw=111');">
							아이디/비밀번호를 잊으셨나요?</p>
						<%} %>
					</td>
				</tr>
			</table>
			<p id="login_join">아직 회원이 아니신가요? <a href="join.jsp">회원가입</a></p>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>