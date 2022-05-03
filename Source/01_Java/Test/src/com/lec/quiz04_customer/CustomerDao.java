package com.lec.quiz04_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static CustomerDao	INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	
	public CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// 1. 가입 	: public int insertCustomer(CustomerDto dto)
	public int insertCustomer(String ctel, String cname, int cpoint) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER VALUES (CUS_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			pstmt.setInt(3, cpoint);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return result;
	} // 1. 가입
	
	
	// 2. 폰조회 	: public ArrayList<CustomerDto> cTelgetCustomer(String ctel)
	public ArrayList<CustomerDto> cTelgetCustomer(String ctel){
		
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER" + 
				"    WHERE CTEL LIKE '%'||?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cno");
				ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				
				dtos.add(new CustomerDto(cid, ctel, cname,  cpoint));
			}
						
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dtos;
	} // 2. 폰조회
	
	
	// 3. 전체출력  : public ArrayList<CustomerDto> getCustomers()
	public ArrayList<CustomerDto> getCustomers(){
		
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				
				dtos.add(new CustomerDto(cno, ctel, cname, cpoint));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // finally
		
		return dtos;
	} // 3. 전체출력
	
	
} // class
