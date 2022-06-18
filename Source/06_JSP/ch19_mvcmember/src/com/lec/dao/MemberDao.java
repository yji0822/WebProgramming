package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.MemberDto;

public class MemberDao {
	
	public static final int SUCCESS = 1; // 회원가입 시 
	public static final int FAIL = 0; // 회원가입 시 
	
	public static final int EXISTENT = 1;
	public static final int NONEXISTENT = 0;
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	// 생성자 함수는 private - 밖에서 새로운 객체를 만들지 못하게 하도록
	private MemberDao() {}
	
	// Connection 객체 얻어오는 함수 getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // tiger, scott, 이런거 잘못 입력하면 에러 발생 - 예외처리 throws SQLException
		} catch (NamingException e) {
			System.out.println("커넥션 풀 이름 오류 : " + e.getMessage());
		}
		return conn;
	} // getConncetion()
	
	// 1. 로그인 
	public int loginChk(String mId, String mPw) {
		
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER WHERE mID = ? and mPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			} else {
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally - try catch
		
 		return result;
	} 
	
	// (2) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
	public MemberDto getMember(String mId) {
		
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER WHERE mId = ?";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// String mId;
				String mPw = rs.getString(dto.getmPw());
				String mName = rs.getString(dto.getmName());
				String mEmail;
				String mPhoto;
				Date   mBirth;
				String mAddress;
				Timestamp mRdate;
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return dto;
	}
	
	
}
