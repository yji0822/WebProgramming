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

	<%-- mysql db연동법 --%>
	<%!
		// 외우지 않는다..! - 커넥션풀을 사용하지 않아도 외부시험에서 아래에 모두 제공이 된다.
		String driverMysql = "com.mysql.jdbc.Driver";
		String urlMysql ="jdbc:mysql://localhost:3306/kimdb";
		String uidMysql = "root";
		String upwMysql = "mysql";
	%>
	
	<table>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSONAL"; // CTRL+SHIFT+X: 대문자 / CTRL+SHIFT+Y: 소문자
		
		try {
			Class.forName(driverMysql); // 1단계 로드 : 드라이버 로드
			conn = DriverManager.getConnection(urlMysql, uidMysql, upwMysql); // 2단계: DB연결객체
			stmt = conn.createStatement(); // 3단계 : sql 전송객체
			rs = stmt.executeQuery(sql); // 4단계 : sql 전송 + 5단계 : 결과 전송 받기
			
			if(rs.next()) {
				out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th>");
				out.println("<th>급여</th><th>상여</th><th>부서번호</th></tr>"); // 타이틀
				// 6단계 : 결과를 이용해서 적당한 로직 수행
				// 데이터가 있는 경우
				do {
					int pno      = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job   = rs.getString("job");
					int manager  = rs.getInt("manager");
					// 출력하는 것은 어떤것으로 해도 상관 없으나, 반납일을 출력한다던가 기타 다른 작업들이 있어야 할 경우에는 날짜형으로 받아와야 한다.
					String startdate = rs.getString("startdate");
					int pay          = rs.getInt("pay");
					int bonus        = rs.getInt("bonus");
					int dno          = rs.getInt("dno");
					
					out.println("<tr><td>" + pno + "</td><td>" + pname + "</td><td>" + job + "</td><td>" 
					+ manager);
					out.println("</td><td>" + startdate + "</td><td>" + pay + "</td><td>" + bonus + "</td><td>"
							+ dno);
					out.println("</td></tr>");
				} while(rs.next());
			} else {
				// 출력할 것이 없는 경우
				out.println("<tr><td>입력된 데이터가 없습니다.</td></tr>");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());			
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());	
			}
 		}
		
	%>
	</table>

</body>
</html>