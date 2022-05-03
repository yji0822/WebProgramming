package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/* 0. 첫화면에 전공이름들 콤보박스에 추가(mName) : public Vector<String> getMNamelist()
 * 1. 학번검색 (sNo, sName, mName, score) : public StudentDto sNogetStudent(String sNo)
 * 2. 이름검색 (sNo, sName, mName, score) : public ArrayList<StudentDto> sNamegetStudent(String sName)
 * 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score) : public ArrayList<StudentDto> mNamegetStudent(String mName)
 * 4. 학생입력 : public int insertStudent(StudentDto dto)
 * 5. 학생수정 : public int updateStudent(StudentDto dto)
 * 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) : public ArrayList<StudentDto> getStudents()
 * 7. 제적자출력  (rank, sName(sNo포함), mName(mNo포함), score) : public ArrayList<StudentDto> getStudentsExpel()
 * 8. 제적처리 : public int sNoExpel(String sNo) */


public class StudentDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	// 싱글톤
	private static StudentDao INSTANCE;
	public static StudentDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	
	public StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} // studentdao
	
	
	// 0. 첫화면에 전공이름들 콤보박스에 추가(mName) : public Vector<String> getMNamelist()
	public Vector<String> getMNamelist(){
		
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MNAME FROM MAJOR";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			}
		}
		return mnames;
	}
	
	
	// 1. 학번검색 (sNo, sName, mName, score) : public StudentDto sNogetStudent(String sNo)
	public StudentDto sNogetStudent(String sNo) {
		
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT sNO, sNAME, mNAME, SCORE " + 
					"    FROM MAJOR M, STUDENT S " + 
					"    WHERE M.mNO = S.mNO AND sNO = ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			// 물음표 채우기
			pstmt.setString(1, sNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				
				dto = new StudentDto(sNo, sName, mName, score);
			
			} else {
				System.out.println("입력하신 학번이 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		} // finally
		 return dto;
	} // sNogetStudent
	
	
	// 2. 이름검색 (sNo, sName, mName, score) : public ArrayList<StudentDto> sNamegetStudent(String sName)
	public ArrayList<StudentDto> sNamegetStudent(String sName){
		
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
				"	    FROM STUDENT S, MAJOR M" + 
				"	    WHERE S.MNO=M.MNO AND SNAME = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sNo = rs.getString("sNo");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(sNo, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			} 
		} // finally
		return dtos;
	} // sNameStudent
	
	// 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score) 
	// : public ArrayList<StudentDto> mNamegetStudent(String mName)
	public ArrayList<StudentDto> mNamegetStudent(String mName){
		
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE " + 
				"	    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE " + 
				"	                FROM STUDENT S, MAJOR M" + 
				"	                WHERE S.MNO=M.MNO AND MNAME= ? " + 
				"	                ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				       mName = rs.getString("mName");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, null, sName, mName, score));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
	} // 3.
	
	// 4. 학생입력 : public int insertStudent(StudentDto dto)
	// insert 학생이름, 전공(전공번호), 점수 입력받음
	public int insertStudent(StudentDto dto) {
		
		int result = FAIL; // 입력 성공여부
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) " + 
				"	    VALUES (EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 4, '0')," + 
				"	             ?, (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} // 4. 학생 입력
	
	// 5. 학생수정 : public int updateStudent(StudentDto dto)
	// update 학번 학생이름 학과 점수
	public int updateStudent(StudentDto dto) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE STUDENT SET SNAME = ?," + 
					"                MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?)," + 
					"                SCORE = ? WHERE SNO = ? ";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getsNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} // 5.
	
	// 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) 
	// : public ArrayList<StudentDto> getStudents()
	public ArrayList<StudentDto> getStudents(){
		
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE " + 
				"	    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE " + 
				"	                FROM STUDENT S, MAJOR M" + 
				"	                WHERE S.MNO=M.MNO AND SEXPEL = 0" + 
				"	                ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, null, sName, mName, score));
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	} // 6번
	
	// 7. 제적자출력  (rank, sName(sNo포함), mName(mNo포함), score) 
	// : public ArrayList<StudentDto> getStudentsExpel()
	public ArrayList<StudentDto> getStudentExpel(){
		
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE" + 
				"	    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE " + 
				"	                FROM STUDENT S, MAJOR M " + 
				"	                WHERE S.MNO=M.MNO AND SEXPEL= 1" + 
				"	                ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, null, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	} // 7
	
	// 8. 제적처리 : public int sNoExpel(String sNo)
	public int sNoExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String sql = "UPDATE STUDENT SET sEXPEL = 1 WHERE SNO = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	

}
