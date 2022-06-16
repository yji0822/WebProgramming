package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1; // 회원가입 시 
	public static final int FAIL = 0; // 회원가입 시 
	
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
	
	
	// 회원가입
	public int joinMember(MemberDto member) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, BIRTH)" + 
				     "    VALUES (?, ?, ?, ?)";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getBirth());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return result;
	}
	
	// 회원리스트
	public ArrayList<MemberDto> listMember(){
		
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				Timestamp birth = rs.getTimestamp("birth");
				Date rdate = rs.getDate("rdate");
				
				members.add(new MemberDto(id, pw, name, birth, rdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return members;
	}
	
	
}
