<%@page import="java.sql.DriverManager"%>
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
</head>

<body>

	<!-- 부서번호와 부서명을 데이터 베이스에서 받아와서 출력할 수 있도록 -->
	<form action="ex3_deptnoOut.jsp">
		부서명 <select name="deptno">
						<option value="0"></option>
						<%
							Connection conn = null;
							Statement stmt = null;
							ResultSet rs = null;
							
							String driver = "oracle.jdbc.driver.OracleDriver";
							String url ="jdbc:oracle:thin:@localhost:1521:xe";
							String sql = "SELECT * FROM DEPT";
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
								stmt = conn.createStatement();
								rs = stmt.executeQuery(sql);
								
								if(rs.next()){
									do {
										// <option value="10"> 10 - sales </option>
										int deptno = rs.getInt("deptno");
										String dname = rs.getString("dname");
										String loc = rs.getString("loc");
										
										out.println("<option value='" + deptno + "'>" + deptno + " - " + dname + "</option>");
									} while (rs.next());
								}
							} catch(Exception e) {
									System.out.println(e.getMessage());
							} finally {
								try {
									if(rs !=null) rs.close();
									if(stmt != null) stmt.close();
									if(conn != null) conn.close();
								} catch(Exception e) {
									System.out.println(e.getMessage());
								}
							}
						%>
					</select>
					<input type="submit" value="조회">
	</form>

</body>
</html>