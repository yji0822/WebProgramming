package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BookDto;

public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	// 생성자 함수는 private - 밖에서 새로운 객체를 만들지 못하게 하도록
	private BookDao() {}
	
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
	
	// 1. 책등록	
	// 2. 책목록(전체list)
	// 3. 책목록(paging : startRow ~ endRow)
	// 4. 등록된 책의 개수
	// 5. 책 상세 보기 (bid로 dto 가져오기)
	
	// 1. 책등록	
	public int insertBook(BookDto book) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)" + 
				"        		 VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setInt(2, book.getBprice());
			pstmt.setString(3, book.getBimage1());
			pstmt.setString(4, book.getBimage2());
			pstmt.setString(5, book.getBcontent());
			pstmt.setInt(6, book.getBdiscount());
			
			result = pstmt.executeUpdate();
			// System.out.println(result == SUCCESS ? "책 등록 성공" : "책 등록 실패");
			// 실패로 갈 수가 없다. 바로 예외처리로 들어가버림 (조건에 맞지 않게 입력한 경우)
			System.out.println("책 등록 성공");
		} catch(SQLException e) {
			System.out.println("데이터베이스 테이블 조건과 맞지 않음" + e.getMessage() + book);
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); // book을 넣어주면 어디서 에러가 났는지 확인 가능하다
			}
		}
		
		return result;
	}
	
	// 2. 책목록(전체list)
	public ArrayList<BookDto> listBook() {
		ArrayList<BookDto> books = new ArrayList<BookDto>(); // 데이터가 아무것도 없는 arraylist
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int    bid       = rs.getInt("bid");
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1"); 
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Date   brdate    = rs.getDate("brdate");
				
				books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); // book을 넣어주면 어디서 에러가 났는지 확인 가능하다
			} // try-catch
		} // finally
		
		return books;
	}
	// 3. 책목록(paging 작업 : startRow ~ endRow) - 2번 로직 전체 복사 후 매개변수를 준다(int StartRow, int endRow)
	public ArrayList<BookDto> listBook(int startRow, int endRow) {
		ArrayList<BookDto> books = new ArrayList<BookDto>(); // 데이터가 아무것도 없는 arraylist
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
					 "    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)" + 
					 "    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int    bid       = rs.getInt("bid");
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1"); 
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Date   brdate    = rs.getDate("brdate");
				
				books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); // book을 넣어주면 어디서 에러가 났는지 확인 가능하다
			} // try-catch
		} // finally
		
		return books;
	}
	
	// 4. 등록된 책의 개수 - 페이징 처리를 하기 위한
	public int getBookTotCnt() {
		int bookTotalCnt = 0; // 최악의 경우 0개 있다.
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 데이터가 없어도 반드시 출력이 된다 cnt가 0일 수도 있으니까!
			// while문 안 적어 주어도 된다.
			rs.next(); // 한행 출력
			bookTotalCnt = rs.getInt("cnt"); 
			// 테이블 상의 타이틀을 적어주는 것이다. "" 안에! 특수문자가 들어가는 경우는 1을 써줘서 첫번째 열을 가지고 오게 한다.
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); // book을 넣어주면 어디서 에러가 났는지 확인 가능하다
			} // try-catch
		} // finally
		
		return bookTotalCnt;
	}
	
	// 5. 책 상세 보기 (bid로 dto 가져오기)
	public BookDto getBook(int bid) {
		BookDto book = null; // 이런 bookid가 없는 것이 최악의 조건
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid); //매개변수로 들어온 bid
			rs = pstmt.executeQuery();
			
			// primary key로 결과값이 1행 아니면 0행이 들어온다.
			// 가져올때는 반드시 필드명!!! title로!
			if(rs.next()) {
				// int    bid       = rs.getInt("bid");
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1"); 
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Date   brdate    = rs.getDate("brdate");
				
				book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); // book을 넣어주면 어디서 에러가 났는지 확인 가능하다
			} // try-catch
		} // finally
		
		return book;
	}
	
}
