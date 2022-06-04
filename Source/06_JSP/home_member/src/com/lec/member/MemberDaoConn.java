package com.lec.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoConn {
	
	// 회원가입, 정보수정 시 
	public static final int SUCCESS = 1; 
	public static final int FAIL = 0;
	
	// id 중복 확인여부 
	public static final int MEMBER_EXISTENT = 0;
	public static final int MEMBER_NONEXISTENT = 1;
	
	// 로그인 성공 실패(아이디 오류, 비밀번호 오류)
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_ID = -1;
	public static final int LOGIN_FAIL_PW = 0;
	
	// 싱글톤
	private static MemberDaoConn instance;
	
	public static MemberDaoConn getInstance() {
		if(instance == null) {
			instance = new MemberDaoConn();
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println("커넥션풀 에러 : " + e.getMessage());
		}
		return conn;
	}
	
	// 1. 회원가입 시, ID 중복 체크를 위한 sql : public int confirmed(String id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 출력할 데이터가 존재한다면 멤버가 존재한다는 메세지 대입
				result = MEMBER_EXISTENT;
			} else {
				result = MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} // try-catch
		} //finally
		
		return result;
	}
	
	// 2. 회원가입 : public int joinMember(MemberDto dto)
	// INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    // VALUES ('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'hong@h.com', '1995-12-12', SYSDATE, '서울')
	public int joinMember(MemberDto dto) {
		int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)" + 
						 "        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPw());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getPhone1());
				pstmt.setString(5, dto.getPhone2());
				pstmt.setString(6, dto.getPhone3());
				pstmt.setString(7, dto.getGender());
				pstmt.setString(8, dto.getEmail());
				pstmt.setTimestamp(9, dto.getBirth());
				pstmt.setString(10, dto.getAddress());
				
				result = pstmt.executeUpdate(); // 결과값에 insert가 성공이 됐는지 안됐는지 확인
				
				System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("회원가입 실패 : " + dto); // toString 호출
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} // try-catch
		} //finally
			
		return result;
	} // 2.
	
	// 3. 로그인(아이디, 비밀번호) public int loginCheck (String id, String pw)
	// SELECT ID, PW FROM MEMBER WHERE ID = 'aaa';
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID; // 로그인 아이디 오류 값을 대입
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// id가 유효한 경우
				String pwDB = rs.getString("pw");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}
	