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

import com.lec.dto.BoardDto;

public class BoardDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	/*
	 * private static BoardDao instance; public static BoardDao getInstance() {
	 * if(instance == null) { instance = new BoardDao(); } return instance; }
	 */	
	// 싱글톤
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}
	
	// Connection 객체를 받아오는 함수 : getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null; // 커넥션 객체를 못만드는게 최악의 조건
		try {
			Context ctx = new InitialContext(); // javax.naming 으로 꼭 import해주기
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // 드라이버가 잘못됐거나... >> SQLException 발생
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		} 
		
		return conn;
	}
	
	// 1. 글갯수 : public int getBoardTotalCnt()
		// 2. 글목록 : public ArrayList<BoardDto> listBoard()
		// 3. 원글쓰기 : public int insertBoard(BoardDto dto)
		// 4. 글번호로 글 한줄 가져오기 : public BoardDto getBoardOneLine(int num)
		// 4. 글번호로 글 한줄 가져오기 : public BoardDto getBoardOneLine(String num)
		// 5. 조회수 올리기 : public void readcountUp(int num)
		// 5. 조회수 올리기 : public void readcountUp(String num)
		// 6. 글 수정 : public int updateBoard(BoardDto dto)
		// 7. 글 삭제 : public int deleteBoard(int num, String pw)
		// 8. 답변글 저장전 step ⓐ
		// 9. 답변글 저장
	
	
	// 1. 글 갯수 : public int getBoardTotalCnt()
	// SELECT COUNT(*) FROM BOARD;
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
			rs.next();
			
			totalCnt = rs.getInt(1); // 1열의 데이터를 int값으로 받아옴
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return totalCnt;
	}
	
	// 2. 글 목록 (최신글이 위로) : public ArrayList<BoardDto> listBoard()
	// SELECT * FROM BOARD ORDER BY NUM DESC;
	public ArrayList<BoardDto> listBoard() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 데이터가 있을 수도 있고 없을 수도 있고! = while
				// dto에서 변수들 다 가져오기!
				int    num = rs.getInt("num"); 
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int    readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int    ref = rs.getInt("ref");
				int    re_step = rs.getInt("re_step");
				int    re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, 
													pw, ref, re_step, re_indent, ip, rdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dtos;
	}
	
	// 3. 글 쓰기 (원글 쓰기) : public int insertBoard(BoardDto dto) - subject, writer, 이렇게 데려오기 번거롭기 때문
	// INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    // VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), '홍길동', '글제목1', '본문입니다.\n금요일이다!', NULL, 
    //        '1', (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, '192.168.10.30' );
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		
		// 데이터베이스에 insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)" + 
				"    VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), ?, ?, ?, ?," + 
				"                ?, (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, ? )";
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
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		 
		return result;
	}
	
	
	// 4. 글 번호(REF로 정렬)로 글(Dto) 가져오기 (한줄 가져오기) : public BoardDto getBoardOneLine(int num)
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			// rs가 1줄 아니면 0줄 출력
			if(rs.next()) {
				// int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int    readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int    ref = rs.getInt("ref");
				int    re_step = rs.getInt("re_step");
				int    re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dto = new BoardDto(num, writer, subject, content, email, readcount, 
										pw, ref, re_step, re_indent, ip, rdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dto;
	}
	
	// 4. 글 번호(REF로 정렬)로 글(Dto) 가져오기 (한줄 가져오기) : public BoardDto getBoardOneLine(String num)
	// parseInt를 해주기 귀찮다면 String형으로 받아오는 것도 방법!
	public BoardDto getBoardOneLine(String num) {
BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			// rs가 1줄 아니면 0줄 출력
			if(rs.next()) {
				// String num = rs.getString("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int    readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int    ref = rs.getInt("ref");
				int    re_step = rs.getInt("re_step");
				int    re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dto = new BoardDto(Integer.parseInt(num), writer, subject, content, email, readcount, 
										pw, ref, re_step, re_indent, ip, rdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dto;
	}
	
	// 5. 조회수 올리기 : public void readcountUp(int num) 
	// UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 1;
	// 글번호가 있으니까 들어왔기 때문에 return 타입이 없어도 된다. 
	// 조회수 올라가는 함수 짠 후에 4번 로직 테스트 수행
	public void readcountUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate(); // 결과를 return을 해줄 이유가 없으므로 업데이트만 시키고 끝내준다.
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
	}
	
	// 5. 조회수 올리기 : public void readcountUp(String num) 
	public void readcountUp(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num); // String num으로 매개변수를 받아오므로
			pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
	}
	
	// 6. 글 수정 : public int updateBoard(BoardDto dto)
	// UPDATE BOARD SET SUBJECT = '수정된 제목',
    // CONTENT = '수정된 본문입니다.\n와우!',
    // EMAIL   = 'hong@hong.com',
    // PW      = '1',
    // IP      = '127.0.0.1'
	// WHERE NUM = 1;
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		
		// 글쓰기와 비슷
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET SUBJECT = ? ," + 
					"                 CONTENT = ? ," + 
					"                 EMAIL   = ? ," + 
					"                 PW      = ? ," + 
					"                 IP      = ? " + 
					"        WHERE NUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getIp());
			pstmt.setInt(6, dto.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return result;
	}
	
	// 7. 글 삭제 (비밀번호 필수) : public int deleteBoard(int num, String pw)
	// DELETE FROM BOARD WHERE NUM = 1 AND PW='1';
	public int deleteBoard(int num, String pw) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM BOARD WHERE NUM = ? AND PW = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate(); // 결과를 return을 해줄 이유가 없으므로 업데이트만 시키고 끝내준다.
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return result;
	}
	
	
	// 8. 페이징 startRow부터 endRow까지만 가져오는 로직
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 2번과 다르게 top-N구문으로 변경됨!
		String sql = "SELECT * " + 
				"     FROM (SELECT ROWNUM RN, A.* " + 
				"        FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow); // 11부터 or 111부터
			pstmt.setInt(2, endRow); // 20까지 or 120까지 출력할지
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int    num = rs.getInt("num"); 
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int    readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int    ref = rs.getInt("ref");
				int    re_step = rs.getInt("re_step");
				int    re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, 
													pw, ref, re_step, re_indent, ip, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dtos;
		
		// list.jsp 들어가서 매개변수 있는 것으로 변경
	}
	
	
	// 8. 답변글 저장 전 stepⓐ :  UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF = 150 AND RE_STEP  > 1
	// reply 하기 전에 이 함수 먼저 호출
	private void preReplyStepA(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=? AND RE_STEP>?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 조정"); // 몇개의 댓글, 대댓글이 조정되었는지 확인
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
	} // 8.
	
	// 9. 답변글 저장
	public int reply(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// dto : num, writer, subject, content, email, pw, ref, re_step, re_indent, ip
		// 사용자로부터 답변글 입력받을 답변글 내용은 ? (원글이랑 비교했을때 바뀌어지는 부분) 
		// 사용자로부터 입력받을 답변글 내용 : writer, subject, content, email, pw
		// reply 호출하기 전 원글의 정보를 불러와야 한다. / 원글에 대한 정보 : ref, re_step, re_indent
		// 시스템으오부터 구현되어 저장될 정보 : ip
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)" + 
					 "     VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// ⓐ step 먼저 실행해주어야 한다.
			preReplyStepA(dto.getRef(), dto.getRe_step()); // 원글에 대한 정보 - 답변글 저장 전 step A!
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setInt(6, dto.getRef()); //원글의 ref를 받아온 상태
			pstmt.setInt(7, dto.getRe_step()+1); // *** 원글의 re_step + 1 을 저장한다는 의미
			pstmt.setInt(8, dto.getRe_indent()+1); // ** 원글의 re_indent + 1을 한다는 의미
			pstmt.setString(9, dto.getIp());
			
			result = pstmt.executeUpdate();
			// DB에 저장될 dto 내용 - re_step랑 re_indent는 각각 +1이 되기 때문에 DB에도 적용시켜 저장 해주어야 한다.
			dto.setRe_step(dto.getRe_step()+1); // result가 1이면 저장성공 0이면 실패
			dto.setRe_indent(dto.getRe_indent()+1);
			System.out.println(result == SUCCESS ? "답변글 성공 - " + dto : "답변글 실패 - " + dto);
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글 실패 : " + dto.toString()); 
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return result;
	} 
}
