package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// 입력, 직업별 조회, 전체 조회 함수 필요 + swing 추가 시 (직업리스트) 추가
public class PersonDao {
// Data Access Object
	
	// 싱글톤
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		public static int SUCCESS = 1; // 연결 성공 시 1 출력 대신 success
		public static int FAIL = 0; // 연결 실패 시 0 출력 대신 fail 입력하는 걸로!
		
		private static PersonDao INSTANCE;
		public static PersonDao getinstance() {
			if(INSTANCE == null) {
				INSTANCE = 	new PersonDao();
			}
			return INSTANCE;
		}
		
		private PersonDao() {
			try {
				Class.forName(driver); // 1단계는 생성자에서 한번!
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} // 생성자
		
		
		// 1번 입력 (매개변수dto, return SUCCESS/FAIL)
		public int insertPerson(PersonDto dto) {
			int result = FAIL;
			// dto 안의 값을 DB에 insert (2~7 단계)
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO PERSON VALUES"
					+ " (PERSON_NO_SEQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // 3
				//물음표 채우기
				pstmt.setString(1, dto.getPname());
				pstmt.setString(2, dto.getJname());
				pstmt.setInt(3, dto.getKor());
				pstmt.setInt(4, dto.getEng());
				pstmt.setInt(5, dto.getMat());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {}
			}
			return result;
		}
		
		// 2번 직업별 조회 (매개변수 jname, return PersonDto arraylist 생성)
		public ArrayList<PersonDto> selectJname(String jname){
			ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
			// 직업별 조회 결과를 dtos에 add (2~7단계) - 배우가 5명이 있으면 5개의 크기를 생성
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT ROWNUM RANK, A.*" + 
					"    FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
					"            FROM PERSON P, JOB J" + 
					"            WHERE P.JNO=J.JNO AND JNAME = ?" + 
					"            ORDER BY SUM DESC) A";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jname);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int rank = rs.getInt("rank");
					String pname = rs.getString("pname");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");
					int sum = rs.getInt("sum");
					dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
			}
			return dtos;
		} // ArrayList 직업별 조회
		
		
		// 3번 전체 조회 (return ArrayList<PersonDo>)
		public ArrayList<PersonDto> selectAll(){
			ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
			// 전체조회 결과를 dtos에 add (2~7단계)
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT ROWNUM RANK, A.*" + 
					"  FROM (SELECT PNAME||'('||PNO||'번)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
					"            FROM PERSON P, JOB J" + 
					"            WHERE P.JNO=J.JNO" + 
					"            ORDER BY SUM DESC) A";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					PersonDto dto = new PersonDto();
					dto.setRank(rs.getInt("rank"));
					dto.setPname(rs.getString("pname"));
					dto.setJname(rs.getString("jname"));
					dto.setKor(rs.getInt("kor"));
					dto.setEng(rs.getInt("eng"));
					dto.setMat(rs.getInt("mat"));
					dto.setSum(rs.getInt("sum"));
					dtos.add(dto);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt != null) stmt.close();
					if(conn!= null) conn.close();
				} catch (SQLException e) {
				}
			}
			
			return dtos;
		} // ArrayList selectAll
		
		
		// 4번 직업리스트 조회 / 오후 콤보박스.. / (return Vector<String>)
		public Vector<String> jnamelist() {
			Vector<String> jnames = new Vector<String>();
			jnames.add(""); // 0번째 인덱스에는 공백칸을 만들어 놓은 뒤 add로 직업 보이도록.
			// 직업명 리스트를 db에서 검색한 후 jname에 add (2~7 단계)
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT JNAME FROM JOB";
			
			try {
				conn = DriverManager.getConnection(url,"scott","tiger");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					jnames.add(rs.getString("jname")); 
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {}
			}
			return jnames;
		} // Vector jnamelist()
		
		
} // PersonDao
