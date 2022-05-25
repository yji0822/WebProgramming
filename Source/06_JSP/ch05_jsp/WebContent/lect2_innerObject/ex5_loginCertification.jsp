<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("1111")) {
			// 있으면 안되는 경우
			// String msg = "check the ID and PW";
			String msg = "<b>아이디와 비밀번호를 확인하세요.</b>";
			msg = URLEncoder.encode(msg, "utf-8"); // 한글로 적힌 문구를 utf-8로 인코딩 해주는 작업
			response.sendRedirect("ex5_loginFrm.jsp?msg=" + msg);
			// 한글을 넣고 싶으면 인코딩 작업!>
		} else {
			out.println("<h4>id는 " + id + "이고, 비밀번호는 " 
		            + pw + "입니다. <br> 반갑습니다.</h4>");
		}
	%>
	
	<h2>
	ID는 <%=id %>이고<br>
	비밀번호는 <%=pw %>입니다.<br>
	반갑습니다.</h2>
	
	<!-- 이페이지에서 바로 실행하게 되면 값이 안들어가있기 때문에 check the ID and PW가 출력되는 페이지가 나온다 -->
</body>
</html>