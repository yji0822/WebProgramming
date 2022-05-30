<%@page import="java.io.PrintWriter"%>
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
		String agree = request.getParameter("agree");
		if(agree.equals("y")){
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
	
			String filePath = "C:\\Users\\dbswj\\Desktop\\WebProgramming\\Source\\06_JSP\\ch08_session\\WebContent\\WEB-INF\\" + id +".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.println("오늘은 DB에 insert 대신 파일 출력");
			writer.println("아이디는 " + id);
			writer.println("비밀번호는 " + pw);
			writer.println("이름은 " + name);
			writer.close();
			
			session.removeAttribute("pw");
			session.removeAttribute("name");
			response.sendRedirect("result.jsp?msg=success");
			
		} else if(agree.equals("n")){
			session.invalidate();
			response.sendRedirect("result.jps?msg=fail");
		}
		
		
	%>	
</body>
</html>