<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<style>
		form{
			text-align: center;
			font-weight: bold;
			font-size: 2em;
		}
		input[type="text"] {
			
		}
	</style>
</head>

<body>

	<form action="">
		이름 <input type="text" name="ename">
		<input type="submit" value="검색">
	</form>
	
	<%
		String ename = request.getParameter("ename");
		if(ename == null) {
			ename = "-1";
		}
		
		if (ename !="-1"){
		
			String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(?)||'%'";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ename);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			out.println("<table>");
			out.println("<tr><th>사번</th><th>이름</th><th>직책</th>" 
			+ "<th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			
			do {
				int empno = rs.getInt("empno");
				ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				out.println("<tr><td>"+ empno +"</td><td>" + ename + "</td><td>" + job +"</td><td>" + mgr + "</td><td>" + hiredate + "</td><td>" + sal + "</td><td>" + comm + "</td><td>" + deptno +"</td></tr>");
			} while(rs.next());
		} else {
			out.println("<table><tr><td>검색하신 사원의 정보가 존재하지 않습니다.</td></tr></table>");
		} // if-else
	}
	%>
	
	

</body>
</html>