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

import com.lec.dto.BoardDto;

public class BoardDao {
	
	public static final int SUCCESS = 1; // 회원가입 시 
	public static final int FAIL = 0; // 회원가입 시 
	
	private DataSource ds /* = null */; // 기본 값이 null 이다(초기화를 해주지 않아도) 
	
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	} // try-catch
	
	// 글목록 - select / ArrayList<BoardDto> listBoard(int startRow, int endRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT *" + 
				     "    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				     "    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int    bid     = rs.getInt("bid");
				String bname   = rs.getString("bname");
				String btitle  = rs.getString("btitle");
				String bcontent= rs.getString("bcontent");
				Date   bdate   = rs.getDate("bdate");
				int    bhit    = rs.getInt("bhit");
				int    bgroup  = rs.getInt("bgroup");
				int    bstep   = rs.getInt("bstep");
				int    bindent = rs.getInt("bindent");
				String bip     = rs.getString("bip");
			
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, 
						bhit, bgroup, bstep, bindent, bip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " list");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return dtos;
	}
	
	// 전체 글 개수 count - SELECT / 1행 1열로 결과쿼리 고정
	public int getBoardTotalCnt() {
		
		int totalCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next(); // 1행1열 무조건 나옴
			totalCnt = rs.getInt(1); // 1행 1열 무조건 불러오기 때문에 변수에 받아준다.
			
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
		
		return totalCnt;
	}
	
	
	// 원글쓰기
	public int write(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
        			"    VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return result;
	}
	
	// bid로 조회수 올리기(private) : update
	private void hitUp(int bid) {

		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
	}
	
	// bid로 dto 가져오기 / 글 상세 보기(조회수 올리기 포함)
	public BoardDto contentView(int bid) {
		//content 페이지 상세보기에 활용
		
		BoardDto dto = null;
		hitUp(bid); // **
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//int    bid     = rs.getInt("bid");
				String bname   = rs.getString("bname");
				String btitle  = rs.getString("btitle");
				String bcontent= rs.getString("bcontent");
				Date   bdate   = rs.getDate("bdate");
				int    bhit    = rs.getInt("bhit");
				int    bgroup  = rs.getInt("bgroup");
				int    bstep   = rs.getInt("bstep");
				int    bindent = rs.getInt("bindent");
				String bip     = rs.getString("bip");
			
				dto = new BoardDto(bid, bname, btitle, bcontent, 
						bdate, bhit, bgroup, bstep, bindent, bip);
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
		
		
		return dto;
	}
	
	// bid로 dto 가져오기 / 수정하기 + 답변글 쓰기 (from, 조회수 올리기 미포함) // 글 상세 보기(조회수 올리기 포함)
	public BoardDto modifyView_replyView(int bid) {
		//content 페이지 상세보기에 활용
		
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//int    bid     = rs.getInt("bid");
				String bname   = rs.getString("bname");
				String btitle  = rs.getString("btitle");
				String bcontent= rs.getString("bcontent");
				Date   bdate   = rs.getDate("bdate");
				int    bhit    = rs.getInt("bhit");
				int    bgroup  = rs.getInt("bgroup");
				int    bstep   = rs.getInt("bstep");
				int    bindent = rs.getInt("bindent");
				String bip     = rs.getString("bip");
				
				dto = new BoardDto(bid, bname, btitle, bcontent, 
						bdate, bhit, bgroup, bstep, bindent, bip);
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
		
		
		return dto;
	}
	
	// 답변글 쓰기 전 step A
	private void preReplyStep(int bgroup, int bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BSTEP=BSTEP+1 WHERE BGROUP = ? AND BSTEP > ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
	}
	
	// 답변글 쓰기 - 답변자 ; bname, btitle, bcontent, bip
	//        - 원글 : bgroup, bstep, bindent
	public int reply(String bname, String btitle, String bcontent, 
							String bip, int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep); // 반드시 Astep 호출!!!
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 원글이랑 같다고 그대로 사용하면 안됨 주의!
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)" + 
				"    VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bip);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "답변글 성공" : "답변글 실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return result;
	}
	
	// 글 수정
	public int modify(int bid, String bname, String btitle, String bcontent, String bip) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BNAME = ?," + 
					 "                 BTITLE = ?," + 
					 "                 BCONTENT = ?," + 
					 "                 BIP = ?" + 
					 "           WHERE BID = ?";
		try {
		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);

			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 수정 성공" : "글 수정 실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 수정 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return result;
	}
	
	// 글  삭제
	public int delete(int bid) {
int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM BOARD WHERE BID = ?";
		try {
		
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "글 삭제 성공" : "글 삭제 실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		
		return result;
	}

	
}
