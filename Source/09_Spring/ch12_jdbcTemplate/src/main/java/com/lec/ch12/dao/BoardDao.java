package com.lec.ch12.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.dto.BoardDto;
import com.lec.ch12.util.Constant;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	public JdbcTemplate template; // constant.template가 되어야 한다
	
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDao() {
		template = Constant.template; // 추가
	}
	
	// 나중에 날릴 친구
	/*private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}*/
	
	// 글목록 - 추가 데이터베이스 연결하는 것으로 
	public ArrayList<BoardDto> boardList() {
		String sql = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		// 마이바티스 - sql 닫고 쏘면 어떤 타입으로 쌓일지 list 타입
		return (ArrayList<BoardDto>) template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	
	// 글목록
	public ArrayList<BoardDto> boardList(final int startRow, final int endRow){
		
		// 1. sql 문을 위로 올리고
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"           FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		
		// 차이점 - 물음표가 있기 때문에 query 함수 호출을 할때 
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// ps대신 익숙한 pstmt로 이름을 바꿔준다
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		/*ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				Date date = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, date, bhit, bgroup, bstep, bindent, bip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;*/
	}
	
	// 글 갯수 
	public int getBoardTotCnt() {
		
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForObject(sql, Integer.class); 
		// sql문의 결과 값이 클래스타입이 아니고 기초변수 타입인 경우에는 Integer 함수를 불러와서 사용
		
		/*int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt; */
	}
	
	
	//원글쓰기
	public int write(final BoardDto bDto) {
		
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
			}
		});
		
		// update라는 함수가 모든 것을 다 한다. - 1이나 0을 가지고 return select문 쿼리에만 new 하고 추가하는 것 안해줘도 된다.
		
		/*
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setString(4, bDto.getBip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글쓰기 성공":"글쓰기 실패 : " + bDto);
		} catch (SQLException e) {
			System.out.println("글쓰기 실패 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result; */
	}
	
	// hit수 올리기 - 물음표 존재 
	private void hitUp(int bid) {
		
		// pstmt 어나니머스 해주기엔 너무 번거롭기 때문에 
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID = ?" + bid;
		template.update(sql); // update는 사용해주지 않아도 된다.
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("조회수 올리기 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}*/
	}
	
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDto contentView(int bid) {
		
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?"+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		// 한줄만 가져올때는 queryforObject 사용
				
		/*BoardDto bDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				Date date = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				bDto = new BoardDto(bid, bname, btitle, bcontent, bdate, date, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return bDto; */
	}
	
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDto modifyView_replyView(int bid) {
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?"+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		/*BoardDto bDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate= rs.getTimestamp("bdate");
				Date date = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				bDto =  new BoardDto(bid, bname, btitle, bcontent, bdate, date, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return bDto; */
	}
	
	
	// 글 수정하기
	public int modify(final BoardDto bDto) {
		
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
				pstmt.setInt(5, bDto.getBid());
			}
		});
		
		/*int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setString(4, bDto.getBip());
			pstmt.setInt(5, bDto.getBid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글수정 성공":"글수정 실패");
		} catch (SQLException e) {
			System.out.println("글수정 실패 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result; */
	}
	
	
	// 글 삭제
	public int delete(int bid) {
		
		String sql = "DELETE FROM MVC_BOARD WHERE BID=?";
		return template.update(sql);
		
		/*int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? bid+"번 글삭제 성공":bid+"번글 삭제실패");
		} catch (SQLException e) {
			System.out.println("글삭제 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result; */
	}
	
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(final int bgroup, final int bstep) {
		
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);
			}
		});
		
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("답변글 쓰기 전 작업 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} */
	}
	
	// 답변글 쓰기
	public int reply(final BoardDto bDto) { // bname, btitle, bcontent, bip : 답변글에 대한 정보
		                             // bgroup, bstep, bindent : 원글에 대한 정보
	
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setInt(4, bDto.getBgroup());
				pstmt.setInt(5, bDto.getBstep()+1);
				pstmt.setInt(6, bDto.getBindent()+1);
				pstmt.setString(7, bDto.getBip());

			}
		});
		
		/* preReplyStepA(bDto.getBgroup(), bDto.getBstep());
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setInt(4, bDto.getBgroup());
			pstmt.setInt(5, bDto.getBstep()+1);
			pstmt.setInt(6, bDto.getBindent()+1);
			pstmt.setString(7, bDto.getBip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "답변쓰기 성공":"답변쓰기 실패");
		} catch (SQLException e) {
			System.out.println("답변쓰기 실패 예외 : "+e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result; */
	}
}