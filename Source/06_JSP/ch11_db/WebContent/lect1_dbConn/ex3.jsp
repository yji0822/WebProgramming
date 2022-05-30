<%@page import="java.sql.Timestamp"%>
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
	<!--  DB연결은 한번 select문은 두번이 들어가게 된다! -->
	<!-- 10을 누르고 결과가 아래에 출력이 되면 10번 부서가 그대로 남아있으면서 결과가 출력되는 형식으로 -->
	<%
		String deptnoStr = request.getParameter("deptno");
		if(deptnoStr == null) {
			deptnoStr = "0";
		} // null이면 0을 대입하고
		int deptno = Integer.parseInt(deptnoStr); // 아니라면 받아온 deptno를 받아서 넣도록! int형으로 형변환
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPT";
	%>

	<!-- 위에는 form 태그가 아래에는 결과값을 출력하는 table -->
	<form action="">
		부서번호 <select name ="deptno">
						<!-- DB에서 받아온 부서번호를 option에서 출력 -->
						<option value='0'></option>
						<%
							try {
							Class.forName(driver); //1단계
							conn = DriverManager.getConnection(url, "scott", "tiger"); //2
							stmt = conn.createStatement(); //3 
							rs = stmt.executeQuery(sql); //4
							
							while(rs.next()) {
								int deptnoDB = rs.getInt("deptno");
								String dname = rs.getString ("dname");
								// 내가 파라미터로 전달 받은 10이 제출버튼을 누르면 그대로 10번 부서가 체크된 채로 넘어갈 수 있도록!
								// <option value ='10' selected = "selected"> 10 - 'SALES' </option> - 선택된 부서
								// <option value ='20'> 20 - 'ACCOUTING' </option> - 체크하지 않은 부분은 기존과 동일하게!
								if(deptno != deptnoDB) {
									// 전달 받은 부서와 다르다면 selected 를 제거한 채 출력
									out.println("<option value = '" + deptnoDB + "'>" 
																		+ deptnoDB + " - " + dname +"</option>");
								} else {
									// 전달받은 부서와 같은 부서번호라면 선택된 채로 넘어갈 수 있도록!
									out.println("<option value = '" + deptnoDB + "' selected ='selected'>" 
											+ deptnoDB + " - " + dname +"</option>");
								}
							}
						} catch(Exception e) {
							System.out.println(e.getMessage());
						} finally {
							if(rs!=null) rs.close();
							if(stmt != null) stmt.close();
							if(conn != null) conn.close();
						}
						%>
					</select>
					<input type ="submit">
					<!-- 어떤걸 선택하고 제출을 해도 다 자기 자신의 페이지로 돌아온다 -->
	</form>
	
	<table>
		<!-- select 파라미터로 받은 부서번호의 사원 정보 테이블에 추가 -->
		<!-- 드라이버 로드는 닫지 않기 때문에 다시 안열어주어도 된다. -->
		<%
			sql = "SELECT * FROM EMP WHERE DEPTNO = " + deptno;
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					// 해당 부서의 사원이 있는 경우
					out.println("<tr><th>이름</th><th>입사일</th><th>급여</th><th>부서번호</th></tr>");
					do {
						String ename = rs.getString("ename");
						Timestamp hiredate = rs.getTimestamp("hiredate");
						int sal = rs.getInt("sal");
						out.println("<tr><td>" + ename + "</td><td>" + hiredate + "</td><td>" + sal
													+ "</td><td>" + deptno + "</td></tr>");
					} while (rs.next());
				} else {
					// 해당 부서의 사원이 없는 경우
					out.println("<tr><td>검색하신 부서의 사원정보가 존재하지 않습니다.</td></tr>");
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			} finally {
				if(rs!=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
		%> 
				
	</table>

</body>
</html>