<%@page import="com.lec.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
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
		// db에 연결해서 출력해주는 함수 호출
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// dao함수 호출을 위한 객체 만들기
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpDTO> dtos = dao.selectDeptno(deptno);
			out.println("<table>");
		if(!dtos.isEmpty()) {
		 //dto에 데이터가 있는 경우
			for(EmpDTO dto : dtos) {
				// 필요한 것만 불러와서 출력
				out.println("<tr><td>" + dto.getEmpno() + "</td><td>" + dto.getEname() + "</td><td>" + dto.getHiredate() 
										+ "</td><td>" + dto.getDeptno() + "</td></tr>");
			}
		} else {
		 // dtos에 데이터가 없는 경우 (size가 0인 것)
		 	out.println("<tr><td> 사원이 존재하지 않습니다. </td></tr>");
		}
		out.println("</table>");
%>			
			
	<button onclick = "location.href='ex3_deptnoIn.html'">다시검색</button>
	<!-- <button onclick = "location.href = 'ex3_deptnoIn.html'"> html로 이동 </button> -->
</body>
</html>