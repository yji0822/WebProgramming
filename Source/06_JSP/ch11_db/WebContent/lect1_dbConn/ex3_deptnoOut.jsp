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
		// 외우지 않는다..! - 커넥션풀을 사용하지 않아도 외부시험에서 아래에 모두 제공이 된다.
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 	"SELECT * FROM EMP WHERE DEPTNO = ?";
		String deptnoStr = request.getParameter("deptno");
		if(deptnoStr == null) {
			deptnoStr = "0";
		}
		int deptno = Integer.parseInt(deptnoStr); // deptno 받아와서 integer로 바꿔주는 작업
		
		try{
			Class.forName(driver); // 1단계
			conn = DriverManager.getConnection(url, uid, upw); // 2단계
			pstmt = conn.prepareStatement(sql); // 3단계 - 객체를 생성할때 sql문을 넣어주는 pstmt
			pstmt.setInt(1, deptno); // 정수형이면 setInt
			rs = pstmt.executeQuery(); // 4단계,5단계
			
			out.println("<table>");
			if(rs.next()) {
				out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					Date hiredate = rs.getDate("hiredate");
					// deptno 는 이미 값을 전달 받았다.
					out.println("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + hiredate + "</td><td>" + deptno);
				} while(rs.next());
			} else {
				out.println("<tr><td>조회하신 부서의 사원 정보가 존재하지 않습니다.</td></tr>");
			}
			out.println("</table>");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs!= null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn!=null) conn.close();
		}
	%>
	<button onclick = "location.href='ex3_deptnoIn.jsp'">다시검색</button>
	<!-- <button onclick = "location.href = 'ex3_deptnoIn.html'"> html로 이동 </button> -->
</body>
</html>