<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")) {
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
			// date형으로 받아오고 싶으면 dto.setBirth(Date.valueOf(tempBrith))
		}
		
		MemberDaoConn mDao = new MemberDaoConn(); // context.xml 에서 connection pool 받아옴
		int result = mDao.confirmId(dto.getId()); // 데이터 베이스에 id가 존재하는지 중복체크 
		if(result == MemberDaoConn.MEMBER_NONEXISTENT) {
			// 아이디가 존재하지 않다면 회원가입 진행
			result = mDao.joinMember(dto); // 빈태그에서 불러온 값들을 저장해준다.
			if(result == MemberDaoConn.SUCCESS) {
				session.setAttribute("id", dto.getId()); // 가입이 성공했으면 id를 세션에 저장해준다.
			}
	%>
		<script>
			alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요!');	
			location.href='login.jsp';
		</script>
	<%} else { // 회원가입 실패 %>
		<script>
			alert('중복된 아이디 입니다. 다른 아이디를 입력해주세요.');
			history.back();
		</script>
		
	<%}%>
</body>
</html>