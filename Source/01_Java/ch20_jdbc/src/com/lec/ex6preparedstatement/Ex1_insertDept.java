package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// INSERT
public class Ex1_insertDept {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner (System.in);
		
		// 받기전에 sql 작성해도 된다.
		// statement : sql 문을 작성하기 전에  scanner 받아서 / preparedStatement : ?로 받았기때문에 위에 적어도 무방
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)"; // 홑따움표도 제거 필수
		// 추가할 데이터 받기 - Scanner
		System.out.print("추가할 부서번호 : ");
		int deptno = sc.nextInt();
		System.out.print("추가할 부서명 : ");
		String dname = sc.next();
		System.out.print("추가할 부서 위치 : ");
		String loc = sc.next();
		
		// 데이터베이스 연결
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // (SQL 전송객체) stmt랑 차이점1 - sql문을 만들때 적어준다
//			stmt = conn.createStatement(); - sql문을 전송할때 만들어준다
			// 차이점2 : 물음표를 채워주는 작업!
			pstmt.setInt(1,  deptno); // sql의 첫번째 물음표에 int값인 deptnt를 setting 해준단 뜻
			pstmt.setString(2, dname); // 두번째 물음표에 String형 dname 세팅
			pstmt.setString(3, loc);
			
			int result = pstmt.executeUpdate(); // sql문 전송 /물음표를 하나만 입력했을 경우 에러발생
//			int result = stmt.excuteUpdate(sql);
			
			System.out.println(result>0 ? deptno + " 번 부서 입력 성공" : "입력 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
		
		
		
	}

}
