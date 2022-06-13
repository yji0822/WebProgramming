<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
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
		FileboardDao fbDao = FileboardDao.getInstance();
		FileboardDto dto = new FileboardDto();
		
		for(int i = 1; i<=70; i++){
			if(i%3 == 0) {
				dto.setCid("aaa"); // 데이터베이스에 있는 아이디를 넣어주어야 한다.
			} else if(i%3==1){
				dto.setCid("bbb");
			} else if(i%3 == 2) {
				dto.setCid("ccc");
			}
			dto.setFsubject("for문으로 생성한 글입니다. " + i);
			dto.setFcontent("본문 내용");
			if(i%5 == 0) {
				dto.setFfilename("쿠키.docx");
			} else {
				// 설정 안해도 null값이 자동으로 들어간다
				dto.setFfilename(null);
			}
			dto.setFpw("111");
			dto.setFip("192.168.10." + i);
			fbDao.insertBoard(dto);
		} 
		response.sendRedirect("fboardList.jsp");
	%>

</body>
</html>