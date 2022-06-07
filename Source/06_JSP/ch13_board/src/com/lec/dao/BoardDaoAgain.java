package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BoardDtoAgain;

public class BoardDaoAgain {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BoardDaoAgain instance = new BoardDaoAgain();
	public static BoardDaoAgain getInstance() {
		return instance;
	}
	
	private BoardDaoAgain() {}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// 1. 글 갯수 : public int getBoardTotalCnt()
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); // 1행 1열이 결과값이기 때문에 따로 while문이 필요하지 않다.
			
			totalCnt = rs.getInt(1); // 1열의 데이터를 int값으로 받아옴
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	} // 1. 글 갯수 확인
	
	// 2. 글 목록(내림차순 정렬) : public ArrayList<BoardDtoAgain> listBoard()
	public ArrayList<BoardDtoAgain> listBoard() {
		ArrayList<BoardDtoAgain> dtos = new ArrayList<BoardDtoAgain>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// dto에 저장된 모든 객체들 불러온기
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");  
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dtos.add(new BoardDtoAgain(num, writer, subject, content, email, 
											readcount, pw, ref, re_step, re_indent, ip, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dtos;
	} // 2. 글목록 출력
	
	// 3. 글 작성 : public int insertBoard(BoardDtoAgain dto) 
	public int insertBoard(BoardDtoAgain dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)" + 
				"    VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), ?, ?, ?, ?," + 
				"                ?, (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		return result;
	} // 3. 글작성
	
	// 4. 글 번호(ref로 정렬) 글DTO 가져오기 (한줄 가져오기) : public BoardDtoAgain getBoardOneLine(int num)
	public BoardDtoAgain getBoardOneLine(int num) {
		int 
	}
	
	
}
