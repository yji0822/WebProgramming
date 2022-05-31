<%@page import="com.lec.member.MemberDao"%>
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

	<%
		request.setCharacterEncoding("utf-8"); // post방식
	%>
	
	<!-- 반드시 매개변수 없는 생성자 있는지 확인 -->
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty name="dto" property="*" />
	
	<%-- <%=dto.toString() %>
	<!-- 제대로 출력되었나 확인하는 작업 --> --%>
	
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			/* dto.setBrith(tempbirth); */
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmId(dto.getId()); //id중복체크
		if(result == MemberDao.MEMBER_NONEXISTENT){
			// 사용가능한 ID
			result = mDao.joinMember(dto); // 회원가입
			if(result == MemberDao.SUCCESS) {
				// 회원가입 성공 - id에다가 세션 저장하고 성공출력
				session.setAttribute("id", dto.getId());
		%>
				<script>
					alert('회원가입 감사합니다. 로그인 후 서비스를 이용 하세요.');
					location.href = 'login.jsp';
				</script>
		<%} else {
				// 회원가입 실패 - 다시 가입해달라고 alert창 띄워주기
		%>
			<script>
				alert('회원가입 실패되었습니다. 다시 가입해주세요.');
				location.href = 'join.jsp';
			</script>	
		<%}
		} else {
			// 중복된 ID %>
			<script>
				alert('중복된 아이디입니다. 다른 아이디를 사용하세요');
				history.back(); /*내가 입력했던 것이 그대로 보이는 history.backs*/
			</script>
		<% } %>
		
</body>
</html>