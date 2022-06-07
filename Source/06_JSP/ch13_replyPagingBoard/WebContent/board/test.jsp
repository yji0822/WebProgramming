<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
		BoardDao bDao = BoardDao.getInstance();
		
	out.println("<h2> 1. DB 글 갯수 : " + bDao.getBoardTotalCnt() + "입니다. </h2>");
	
	out.println("<h2> 2. 글 목록  </h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos) {
		out.println(dto + "<br>");
	}
	
	out.println("<h2> 3. 글쓰기 </h3>");
	// public BoardDto(int num, String writer, String subject, String content, String email, 
	//		int readcount, String pw, int ref, int re_step, int re_indent, String ip, Timestamp rdate)
	BoardDto dto = new BoardDto(0, "김길동", "글제목 n", "본문입니다!!!!!\n 오늘은 금요일", 
																						"kim@naver.com", 0, "1", 0, 0, 0, "127.0.0.2", null ); 
	int result = bDao.insertBoard(dto);
	out.println(result == BoardDao.SUCCESS ? "글쓰기 성공" : "글쓰기 실패");
	
	out.println("<h2> 4&5. 조회수 올리고 글 번호로 dto 가져오기</h2>");
	bDao.readcountUp(10); // 7번 글 가져오는 것
	dto = bDao.getBoardOneLine(10); // 7번글 가져오기
	out.println(dto);
	
	out.println("수정 전의 7번 글 " + dto);
	out.println("<h2> 6. 글 수정 </h2>");
	dto.setSubject("바뀐 제목 xxxx");// 제목에 세팅
	dto.setContent("바뀐 본문 yyyy"); // 본문에 세팅
	result = bDao.updateBoard(dto); // 결과값 업데이트
	if(result == BoardDao.SUCCESS) {
		dto = bDao.getBoardOneLine(10); 
		out.println("수정 후의 10번 글 : " + dto);
	} else {
		out.println("수정 실패");
	}
	
	out.println("<h2> 7. 10번글 삭제 </h2>");
	result = bDao.deleteBoard(10,"1111");
	out.println(result == BoardDao.SUCCESS ? "7번글 삭제 성공" : "7번글 삭제 실패(비번 인위적으로 틀렸음)");
	result = bDao.deleteBoard(10, "1");
	out.println(result == BoardDao.SUCCESS ? "7번글 삭제성공(비번 맞음)" : "7번글 삭제 실패");
	
	
	%>

</body>
</html>