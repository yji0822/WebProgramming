package com.lec.ex1_person;
// 1. 입력 / 2. 직업별 조회 / 3. 전체 조회 / 그외 종료
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		String fn, sql;
		
		Connection        conn  = null;
		Statement         stmt  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
				
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			System.out.print("1. 입력 | 2. 직업별조회 | 3. 전체조회 | 4. 그외 : 종료");
			fn = sc.next(); // 123,a
			switch(fn) { // 정수, 문자
			case "1": 
				System.out.println("1. 입력할 이름, 직업명, 국, 영, 수 입력 받아 insert");
				sql = "INSERT INTO PERSON VALUES" + 
						"    (PERSON_NO_SEQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
				System.out.print("이름 : ");
				String pname = sc.next();
				System.out.print("직업명 : ");
				String jname = sc.next();
				System.out.print("국어점수 : ");
				int kor = sc.nextInt();
				System.out.print("영어점수 : ");
				int eng = sc.nextInt();
				System.out.print("수학점수 : ");
				int mat = sc.nextInt();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "입력 성공" : "입력실패");
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {}
				}
				
				break;
				
			case "2":
				System.out.println("2. 직업명을 입력 받아 해당 직업별 조회 출력");
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT pNAME ||'('||PNO||'번)' pNAME, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"SUM\"" + 
						"    FROM PERSON P, JOB J WHERE P.jNO = J.jNO AND JNAME = ? ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("직업은 (배우? 가수?)");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t이름\t\t직업\t국\t영\t수\t총점");
						do {
							int rank = rs.getInt("rank");
							pname = rs.getString("pname");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"등\t" + pname +"\t"+jname +"\t"+ kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while (rs.next());
					} else {
						System.out.println("해당 직업 사람 x");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) rs.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {}
				}
				
				break;
				
			case "3":
				System.out.println("3. 전체 출력");
				// 2~7단계
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, "+
													 "MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO" + 
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
//					pstmt = conn.prepareStatement(sql); // (3) - sql을 품고 생성
					stmt = conn.createStatement();
//					rs = pstmt.executeQuery(); // (4) + (5)
					rs = stmt.executeQuery(sql); // - 나중에 뿌리는 용도
					if(rs.next()) { // 직업별 출력
						System.out.println("rank\t이름\t직업\t국\t영\t수\t총점");
						do {
							int rank  = rs.getInt("rank");
							pname     = rs.getString("pname");
							jname     = rs.getString("jname");
							kor       = rs.getInt("kor");
							eng       = rs.getInt("eng");
							mat       = rs.getInt("mat");
							int sum   = rs.getInt("sum");
							System.out.println(rank+"등\t"+pname+"\t\t"+jname+"\t"+kor+"\t"+
									eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("해당 직업의 사람이 입력되지 않았습니다");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e) {
						
					}
				}
				
				break;
			}
			
			
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("프로그램 종료");

	}

}
