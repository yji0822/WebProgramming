package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class selectAllOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null; // db 연결 객체 
		Statement stmt = null; // sql 전송하는 객체
		
		// (1) select 결과가 여러줄 - 단순한 정수가 아님
		ResultSet rs = null; // SELECT문 결과 받는 객체 변수
		String query = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver);                             // 1. 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. db연결
			stmt = conn.createStatement();                     // 3. sql문 전송 객체 생성
			rs   = stmt.executeQuery(query);                   // 4. sql문 전송 + 5. sql 전송 결과 받음
			
			// 6. 결과 받아 원하는 로직 수행 (결과 받은 변수 : rs)
			// 정보가 있으면 뿌리고 없으면 정보가 없으면 없다고 가르키는 작업....
			// 데이터가 몇개 있는지 모름 - while문으로 출력
			// rs.next -> 받아올 것이 없으면 false 출력
			
			System.out.println("사번 \t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호"); // 타이틀 출력
			
			while(rs.next()) { // 14번 돌아가는 while문
				// number로 설정한 것은 int and String으로 받아도 된다.
				int    empno = rs.getInt("empno"); // 대소문자 구분 x, 특수문자 없도록 db 필드별칭 설정 
//				String empno = rs.getString("empno"); // 필드 별칭이 있으면 별칭 가져오고, 아니면 그냥 설정한 것 출력
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				int    mgr   = rs.getInt("mgr");
//				Date   hiredate = rs.getDate("hiredate"); // (추천) sql로 api 받아오기
//				String hiredate = rs.getString("hiredate"); // (비추) Date함수도 String으로 받아도 됨 (시간까지 같이 출력될걸...?)
				Timestamp hiredate = rs.getTimestamp("hiredate"); // (추천) sql api!
				int       sal      = rs.getInt("sal");
				int       comm     = rs.getInt("comm");
				int       deptno   = rs.getInt("deptno");
				
				// 콘솔 상에서만 사용하는 로직..(보기 쉽게 하기 위해서)
				if(job.length() >= 8) { // 8글자 이상이면 탭 한번
					System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} else { // 8글자 이하이면 탭 두번
					System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} // if-else
			} // while
			
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
		
		
		// select 전송 ; executeQuery 함수 이용 / 결과 : rs에 받음
		// (2) insert, update, delete - 결과가 0, 정수로 표현이 된다.
		
	} // main
} // class

