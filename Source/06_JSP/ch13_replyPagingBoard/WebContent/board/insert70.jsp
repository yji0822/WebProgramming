<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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

	<!-- 임의로 70개의 게시글 insert 해주고 list.jsp에 sendRedirect 하는 로직 -->
	<%
		// dto 객체가 있어야 하고 작성자 제목 본문... 다 들어가야 한다. (insertBoard() 함수 사용하기 위해)
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = new BoardDto();
		
		// 확장 for문이 아닌 일반 for문으로 간다
		for(int i = 1; i <= 70; i++) {
			// 구분을 위하여 옆에 i를 붙여준다.
			dto.setWriter("테스트" + i);
			dto.setSubject("제목" + i +" 입니다.");
			dto.setContent("본문입니다." + i);
			dto.setEmail("test" + i + "@yahoo.com");
			dto.setPw("1");
			dto.setIp("527.1.2." + i );
			
			// 메소드 호출
			int result = dao.insertBoard(dto);
			System.out.println(result == BoardDao.SUCCESS ? i+"번째 글쓰기 성공" : i +"번째 글쓰기 실패");
		}
		
		response.sendRedirect("list.jsp");		
	
	%>

</body>
</html>