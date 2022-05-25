<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
		String conPath = request.getContextPath(); // 서블릿이나 css를 걸때 사용한다.
	String appPath = application.getContextPath(); // 상대경로 - /ch05_jsp
	String absolutePath = application.getRealPath("."); // 현재 프로젝트의 절대경로
	// 실행은 톰캣이.
	%>
	<!-- 절대경로가 어디서 실행이 되는지 확인 -->
	<h2>
		conPath :
		<%=conPath%></h2>
	<h2>
		conPath :
		<%=appPath%></h2>
	<h2>
		conPath :
		<%=absolutePath%></h2>
	<!-- 실행은 아파치 폴더에서 실행한다 -->

	<%
	// 자바 파일 입출력 
	String filePath = application.getRealPath("WEB-INF/input.txt"); // 절대경로
	out.println(filePath + "의 내용입니다.<br><br>");
	// 스트림 객체 생성(파일 연다) - 읽는다 - 스트림 객체를 해제(파일 닫는다)
	// 적극적으로 try-catch 안해도 된다.
	BufferedReader br = new BufferedReader(new FileReader(filePath)); // 스트림 객체 생성 기본스트림 FileReader를 가져온다.
	while (true) {
		String line = br.readLine(); // 파일 읽기 (한줄씩). 파일의 끝이면 null 리턴(반환)
		if (line == null) {
			break;
		} // if
		out.println(line + "<br>");
	} // while
	br.close();

	/* 기존에 우리가 Java로 빡세게 구현했던 로직
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(filePath)); // 스트림객체 생성
		while(true) {
			String line = br.readLine(); // 파일 읽기 (한줄씩). 파일의 끝이면 null 리턴(반환)
			if(line == null) {
		break;
			}
			out.println(line + "<br>");
		}
	} catch(Exception e) {
		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다.");
	} finally {
		try {
			if(br != null){
		br.close();
			}
		} catch(Exception e) {
			
		}
	} */
	%>

</body>
</html>