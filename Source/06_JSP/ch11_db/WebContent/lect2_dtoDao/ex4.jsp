<%@page import="com.lec.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDAO"%>
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
		String searchName = request.getParameter("searchName");
		if(searchName == null) {
			searchName = "";
		}
	%>
	
	<form action ="">
		<p> 
			이름 <input type="text" name="searchName" value="<%= searchName.toUpperCase() %>">
			   <input type="submit" value="검색">
		</p>
	</form>
	
	<table>
		<%
			EmpDAO dao = EmpDAO.getInstance(); // 함수 호출 가능하도록
			ArrayList<EmpDTO> emps = dao.selectSearchName(searchName);
			out.println("<tr><th>사번</th><th>이름</th><th>직책</th>" 
					+ "<th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			
			if(emps.size() != 0) {
				for(EmpDTO emp : emps) {
					out.println("<tr><td>" + emp.getEmpno() + "</td><td>" + emp.getEname() + "</td><td>" + emp.getJob() 
											+ "</td><td>" + emp.getMgr() + "</td><td>" + emp.getHiredate() + "</td><td>" + emp.getSal() + "</td><td>" 
											+ emp.getComm() + "</td><td>" + emp.getDeptno() + "</td></tr>");
				}
			} else {
				out.println("<tr><td colspan='8'>조회하신 사원이름의 정보가 존재하지 않습니다. </td></tr>");
			}
		%>
	</table>

</body>
</html>