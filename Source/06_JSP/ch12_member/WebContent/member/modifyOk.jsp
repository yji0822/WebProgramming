<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
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

	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		// 빈스트링이 들어왔으면 가만히 냅두고 아닌 경우에는...!
		if(!tempbirth.equals("")) {
			// 무언가를 입력했단 의미
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		}
		
		// 현비밀번호는 session에 있다
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member != null) {
			// member.getPw()부터 실행하면 에러발생 가능성이 있다.
			sessionPw = member.getPw(); // 세션의 pw를 sessionPw에 할당
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			// 현비밀번호를 맞게 입력한 경우 정보 수정 진행
			// 새 비밀번호(pw파라미터)가 null
			if(dto.getPw() == null) {
				dto.setPw(sessionPw);
			}
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.modifyMember(dto);
			if(result == MemberDao.SUCCESS) {
				// 수정성공 - 세션에도 저장을 해주어야 한다.
				session.setAttribute("member", dto);
			%>
				<script>
					alert('회원정보 수정이 완료되었습니다.');
					location.href = 'main.jsp';
				</script>
			<%} else {
				// 수정실패
				out.println("<script>");
				out.println("alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다.')");
				out.println("location.href='modify.jsp'");
				out.println("</script>");
			}
		} else {
			// 현 비밀번호를 틀리게 입력한 경우 정보 수정 안 함
		%>
			<script>
				alert('현 비밀번호가 바르지 않습니다. 확인하세요.');
				history.back();
			</script>	
		<% } %>
</body>
</html>