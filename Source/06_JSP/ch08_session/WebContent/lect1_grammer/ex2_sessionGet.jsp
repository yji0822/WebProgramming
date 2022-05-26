<%@page import="java.util.Enumeration"%>
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
		// 특정 session 값 받아올 것 - 반드시 ex1_sessionAddAttribute.jsp 에서 실행하자
		
		// 특정 session 속성 값 가져오기
		String sessionName = (String)session.getAttribute("sessionName"); // object type을 넣어주어야 하기 때문에 형변환 필수!
		Integer myNum = (Integer)session.getAttribute("myNum");
   										// session.setAttribute("myNum", 123);
		out.println("sessionName은 " + sessionName + "<br>");
		out.println("myNum은 " + myNum + "<br>");
		out.println("id는 " + session.getAttribute("id") + "<br>"); // 추가한 속성이 없을 경우 null값 리턴
	
	
		// 모든 세션 속성 리스트 출력 - 내가 가져와서 출력하는 것
		out.println("<h4> 모든 세션 속성들 list </h4>");
		Enumeration<String> sAttrNames = session.getAttributeNames(); // 0번째 세션을 가르킨다(Enumeration - 열거하는 함수(import해야한다.))
		int cnt = 0; // 열거하는 로직
		while(sAttrNames.hasMoreElements()) {
			// 다음 엘리먼트가 존재하니?
			String sname = sAttrNames.nextElement(); // 다음 엘리먼트의 이름 저장 // 세션(속성)이름
			String svalue = session.getAttribute(sname).toString(); // 엘리먼트 받아올때는 getAttribute 형변환 or toString 중에 하나 해주기 // 세션(속성)값
			out.println(sname + "(세션이름) / " + svalue + "(세션값)<br>");
			cnt++;
		}
		if(cnt == 0) {
			out.println("추가된 세션 속성이 없습니다.");
		}
		
		// 특정 세션 삭제하기 (로그아웃시 사용)
		session.removeAttribute("myNum");
		out.println("<h4> myNum 세션 속성 삭제 후</h4>");
		
		sAttrNames = session.getAttributeNames(); // 0번째 세션을 가르킨다(Enumeration - 열거하는 함수(import해야한다.))
		cnt = 0; // 열거하는 로직
		
		while(sAttrNames.hasMoreElements()) {
			// 다음 엘리먼트가 존재하니?
			String sname = sAttrNames.nextElement(); // 다음 엘리먼트의 이름 저장 // 세션(속성)이름
			String svalue = session.getAttribute(sname).toString(); // 엘리먼트 받아올때는 getAttribute 형변환 or toString 중에 하나 해주기 // 세션(속성)값
			out.println(sname + "(세션이름) / " + svalue + "(세션값)<br>");
			cnt++;
		}
		if(cnt == 0) {
			out.println("추가된 세션 속성이 없습니다.");
		}
		
		// 모든 세션 삭제하기 (로그아웃 시 사용)
		session.invalidate(); //setAttribute 했던 모든 세션 속성값 다 삭제
		if(request.isRequestedSessionIdValid()) {
			// 유효한 세션 속성이 있는지 확인 여부
			out.println("session valid<br>");
		} else {
			out.println("session invalid<br>");
		}
		out.println("<h3> 세션ID : " + session.getId() + "</h3>");
		out.println("<h3> 세션의 유효시간 : " + session.getMaxInactiveInterval() + "<br>"); // 세션의 유효시간을 뿌리는 함수 - 톰캣의 설정파일에서 
	%>
	

</body>
</html>