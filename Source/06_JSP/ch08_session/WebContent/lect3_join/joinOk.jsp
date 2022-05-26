<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- 머무르지 않을 페이지라 css X -->
</head>

<body>

	<%
		String agree = request.getParameter("agree");
		if(agree.equals("y")) {
			// 약관 동의한 경우 (세션 속성값 받아 파일에 저장, 일부 세션 남기는 작업 >> 다음 페이지로 넘기기)
			// DB에 저장할 객체들 모두 받아오기
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			
			// 파일저장(소스폴더로!!! WebContent/WEB-INF/id.txt) - 방금 받은 파라미터를 id.txt로 저장 
			// 절대경로 - 톰캣 폴더에 저장. - realpath에 저장하면 안된다. (껐다켰다 하면 파일이 저장이 안된다. 소스 폴더에 저장)
			String filePath = "D:/webPro/source/06_JSP/ch08_session/WebContent/WEB-INF/" + id +".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.println("오늘은 DB에 insert 대신 파일 출력");
			writer.println("아이디는 " + id);
			writer.println("비밀번호는 " + pw);
			writer.println("이름은 " + name);
			writer.close();
			// JSP로 작성 시, try-catch가 엄격하지 않다.
			
			session.removeAttribute("pw");
			session.removeAttribute("name");
			// 세션의 id 속성은 유지 - 성공 시 id를 화면에 출력하기 위함
			
			response.sendRedirect("result.jsp?msg=success");
			
		} else if(agree.equals("n")) {
			// else 로 해도 checked="checked"를 했기 때문에 상관 없다.
			// 약관에 동의하지 않은 경우 - 저장 X >> (세션 모두 날리는 작업)
			session.invalidate(); // 유효한 세션 속성 삭제
			response.sendRedirect("result.jsp?msg=fail");
		}
	%>

</body>
</html>