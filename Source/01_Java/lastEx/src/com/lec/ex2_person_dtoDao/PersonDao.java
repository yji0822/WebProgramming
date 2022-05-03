package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// �Է�, ������ ��ȸ, ��ü ��ȸ �Լ� �ʿ� + swing �߰� �� (��������Ʈ) �߰�
public class PersonDao {
// Data Access Object
	
	// �̱���
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		public static int SUCCESS = 1; // ���� ���� �� 1 ��� ��� success
		public static int FAIL = 0; // ���� ���� �� 0 ��� ��� fail �Է��ϴ� �ɷ�!
		
		private static PersonDao INSTANCE;
		public static PersonDao getinstance() {
			if(INSTANCE == null) {
				INSTANCE = 	new PersonDao();
			}
			return INSTANCE;
		}
		
		private PersonDao() {
			try {
				Class.forName(driver); // 1�ܰ�� �����ڿ��� �ѹ�!
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} // ������
		
		
		// 1�� �Է� (�Ű�����dto, return SUCCESS/FAIL)
		public int insertPerson(PersonDto dto) {
			int result = FAIL;
			// dto ���� ���� DB�� insert (2~7 �ܰ�)
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO PERSON VALUES"
					+ " (PERSON_NO_SEQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // 3
				//����ǥ ä���
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
		
		// 2�� ������ ��ȸ (�Ű����� jname, return PersonDto arraylist ����)
		public ArrayList<PersonDto> selectJname(String jname){
			ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
			// ������ ��ȸ ����� dtos�� add (2~7�ܰ�) - ��찡 5���� ������ 5���� ũ�⸦ ����
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT ROWNUM RANK, A.*" + 
					"    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
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
		} // ArrayList ������ ��ȸ
		
		
		// 3�� ��ü ��ȸ (return ArrayList<PersonDo>)
		public ArrayList<PersonDto> selectAll(){
			ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
			// ��ü��ȸ ����� dtos�� add (2~7�ܰ�)
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT ROWNUM RANK, A.*" + 
					"  FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
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
		
		
		// 4�� ��������Ʈ ��ȸ / ���� �޺��ڽ�.. / (return Vector<String>)
		public Vector<String> jnamelist() {
			Vector<String> jnames = new Vector<String>();
			jnames.add(""); // 0��° �ε������� ����ĭ�� ����� ���� �� add�� ���� ���̵���.
			// ������ ����Ʈ�� db���� �˻��� �� jname�� add (2~7 �ܰ�)
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
