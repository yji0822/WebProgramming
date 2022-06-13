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

import com.lec.dto.CustomerDto;

public class CustomerDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 회원가입 중에 아이디 중복체크 여부
	public static final int CUSTOMER_NONEXISTENT = 1;
	public static final int CUSTOMER_EXISTENT = 0;
	// 로그인이 됐는지 안됐는지
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;
	
	// 싱글톤
	private static CustomerDao instance = new CustomerDao();
	public static CustomerDao getInstance() {
		return instance;
	}
	// 생성자 함수는 private - 밖에서 새로운 객체를 만들지 못하게 하도록
	private CustomerDao() {}
	
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
	
	//  ★★ 고객(CUSTOMER) 테이블 DAO ★★
	// 1. 회원가입 시 cid 중복 체크
	public int confirmedCid(String cid) {
		int result = CUSTOMER_EXISTENT; // 아이디가 중복인 경우 (초기화)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = CUSTOMER_NONEXISTENT;
			} else {
				result = CUSTOMER_EXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
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
			}
		} // finally
		
		
		return result;
	}

	// 2. 회원가입 - insert
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)" + 
					 "    VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			
			result = pstmt.executeUpdate();
			System.out.println("회원가입 성공");
			// System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패");
		} catch (SQLException e) {
			System.out.println("회원가입실패 : " + e.getMessage() + dto);
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
		} // finally
		
		
		return result;
	}
	
	// 3. 로그인(cid/CPW)
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ? AND CPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = LOGIN_SUCCESS;
			} else {
				result=LOGIN_FAIL;
			}
		} catch (SQLException e) {
			System.out.println("회원가입실패 : " + e.getMessage());
		} finally {
			try {
				if(rs!=null) {
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
			}
		} // finally
		
		return result;
	}
	// 4. CID로 DTO 가져오기 : select
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 // String cid - 매개변수로 받아옴;
				 String cpw = rs.getString("cpw");
				 String cname = rs.getString("cname");
				 String ctel = rs.getString("ctel");
				 String cemail = rs.getString("cemail");
				 String caddress = rs.getString("caddress");
				 String cgender = rs.getString("cgender");
				 Date   cbirth = rs.getDate("cbirth");
				 Date   crdate = rs.getDate("crdate");
				 
				 dto = new CustomerDto(cid, cpw, cname, ctel, cemail, 
						 					caddress, cgender, cbirth, crdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		}
		
		
		return dto;
	}
	
	// 5. 회원정보 수정 : update
	public int updateCustomer (CustomerDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET CPW = ?," + 
				"                    CNAME = ?," + 
				"                    CTEL = ?," + 
				"                    CEMAIL = ?," + 
				"                    CADDRESS = ?," + 
				"                    CGENDER = ?," + 
				"                    CBIRTH = ?" + 
				"            WHERE CID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6, dto.getCgender());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCid());
			
			result = pstmt.executeUpdate();
			System.out.println("회원 정보 수정 성공");

		} catch (SQLException e) {
			System.out.println("회원 정보 수정 실패.. : " + e.getMessage() + dto);
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
		} // finally
		
		return result;
	}
	
	// 6. 회원 리스트 보기 (첫화면 main.jsp에서 사용할 부분 - top-N구문 : select
	public ArrayList<CustomerDto> listCustomer (int startRow, int endRow){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * " + 
					 "    FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS " + 
					 "            FROM (SELECT * FROM CUSTOMER ORDER BY CID))" + 
					 "    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 String cid  = rs.getString("cid");
				 String cpw = rs.getString("cpw");
				 String cname = rs.getString("cname");
				 String cemail = rs.getString("cemail");
				 String caddress = rs.getString("caddress");				 
				 dtos.add(new CustomerDto(cid, cpw, cname, null, cemail, caddress, null, null, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		}
		
		return dtos;
	}
	
	// 7. 등록된 회원 수  : select, return 값은 int
	public int getCustomerCnt() {
		int totCnt = 0; // 최악의 경우는 0명
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) TOTCNT FROM CUSTOMER";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("totcnt"); // 별칭 준 것으로 꼭!!
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		}
		
		return totCnt;
	}
	
}
