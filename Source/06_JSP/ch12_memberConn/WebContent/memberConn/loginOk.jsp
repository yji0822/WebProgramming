<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDaoConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.loginCheck(id, pw);
		
		if(result == MemberDaoConn.LOGIN_SUCCESS) {
			// 로그인 성공. id를 member라는 변수로 가져와서 정보들을 받아온 후 세션으로 넣어놓는다.
			MemberDto member = mDao.getMember(id); // pstmt로 입력 받은 id 값
			session.setAttribute("member", member);
			response.sendRedirect("main.jsp");
		} else if(result == MemberDaoConn.LOGIN_FAIL_PW) { %>
			<script>
				alert('비밀번호를 확인하세요');
				history.back();
			</script>
		<%} else { %>
			<script>
				alert('존재하지 않는 아이디입니다.');
				histroy.go(-1);
			</script>
	<%}%>
</body>
</html>