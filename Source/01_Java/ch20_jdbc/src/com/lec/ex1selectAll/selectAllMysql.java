package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectAllMysql {

	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";

		String sql = "SELECT * FROM PERSONAL"; // 철자 주의
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs  = null;
		
		try {
			Class.forName(driver); // 드라이버 로드
			conn = DriverManager.getConnection(url, "root", "mysql"); // sql접속
			stmt = conn.createStatement(); // sql 전송 객체
			rs   = stmt.executeQuery(sql); // sql 전송하고 전송받음
			
			// 데이터가 없으면 false 반환하기 때문에 if-else로 구분 해준다. 
			if(rs.next()) { // select문 결과가 1행 이상 있는 경우
				System.out.println("사번 \t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
				do {
					int pno			 = rs.getInt("pno");
					String pname     = rs.getString("pname");
					String job       = rs.getString("job");
					int manager      = rs.getInt("manager");
					Date startdate   = rs.getDate("startdate");
					int pay          = rs.getInt("pay");
					int bonus        = rs.getInt("bonus");
					int dno          = rs.getInt("dno"); // title 출력
					
				if(job.length() >= 8) {
					System.out.println(pno + "\t" + pname + "\t" + job + "\t" + manager + "\t" + startdate + "\t"
							+ pay + "\t" + bonus + "\t" + dno);
				} else {
					System.out.println(pno + "\t" + pname + "\t" + job + "\t\t" + manager + "\t" + startdate + "\t"
							+ pay + "\t" + bonus + "\t" + dno);
				}
					
				} while (rs.next());
			} else {
				System.out.println("PERSONAL 테이블에 데이터가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. 연결해제 *** 객체 연 순서 반대로 닫아주기!
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {	}
		} // finally - try- catch
		
		
	}

}
