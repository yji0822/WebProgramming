package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class MemberDao {
	
	// 리턴값
	public static final int SUCCESS = 1; // 회원가입, 정보수정 시 성공 리턴 
	public static final int FAIL = 0; // 회원가입, 정보 수정 시 실패 리턴값
	public static final int MEMBER_EXISTENT = 0; // 중복된 id일때 리턴값
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 id일때 리턴값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공 시 리턴값
	public static final int LOGIN_FAIL_ID = -1; // 로그인 실패 - id 오류일때 리턴값
	public static final int LOGIN_FAIL_PW = 0; // 로그인 실패 - pw 오류일때 리턴값
	
	// 싱글톤 
	private static MemberDao instance; // 자기가 자기자신의 클래스 참조
	// new 할때 static 함수 호출하도록
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	// new 사용해서 사용할 수 없게 하도록
	private MemberDao() {}
	
	// conn 객체 리턴하는 함수
	public Connection getConnection() throws Exception /*ClassNotFoundException, SQLException*/ {
		// 호출한 곳에서 try-catch
		// 드라이버로드
		Class.forName("oracle.jdbc.OracleDriver"); // (1)
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn; // connection을 받아서 리턴하는 것
	}
	
	// 1. 회원가입 시 ID 중복 체크를 위한 SQL : public int confirmId(String id) 
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT;
		//중복인지 사용 가능인지 SQL로 조회 : SELECT * FROM MEMBER WHERE ID = 'aaa';
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)
			// id = primary key이기 때문에 많아봤자 1줄만 출력이 된다.
			if(rs.next()) {
				// 존재한다면 아이디를 사용하고 있단 뜻
				result = MEMBER_EXISTENT; // 있는 id - 중복된 id 존재
			} else {
				result = MEMBER_NONEXISTENT; // 없는 id - 사용 가능한 id
			}
		} catch (Exception e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 회원가입 : public int joinMember(MemberDto dto)
	// : INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    // VALUES ('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'hong@h.com', '1995-12-12', SYSDATE, '서울');
	public int joinMember(MemberDto dto) {
		int result = FAIL; // insert가 안되는 상황
		// dto DB에 insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)" + 
					 "        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		try {
			conn = getConnection(); // 드라이버 호출
			pstmt = conn.prepareStatement(sql);
			// 값 넣어주기
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
			// sql 문 전송
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS? "회원가입성공" : "회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : " + dto/* .toString() */);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 3. 로그인(id/pw) : public int loginCheck(String id, String pw) 
	// : SELECT ID, PW FROM MEMBER WHERE ID = 'aaa';
	public int loginCheck(String id, String pw) {
		
		int result = LOGIN_FAIL_ID; // 초기화
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)
			if(rs.next()) {
				// 유효한 id를 입력
				// pw를 제대로 친 경우, 아닌경우
				String pwDB = rs.getString("pw"); // rs.next() 해서 받아온 pw - String pw와 같은지 안같은지 확인
				if(pwDB.equals(pw)) {
					// 내가 입력한 pw와 db의 pw가 같은 경우
					result = LOGIN_SUCCESS;
				} else {
					// 비밀번호 잘못 입력한 경우
					result = LOGIN_FAIL_PW;
				}
			} else {
				// 유효하지 않은 id 입력
				result = LOGIN_FAIL_ID;
			}
		} catch (Exception e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 4. ID로 dto 가져오기(로그인 성공 시) : public MemberDto getMember(String id)
	// SELECT * FROM MEMBER WHERE ID = 'aaa';
	public MemberDto getMember(String id) {
		
		// aaa가 없는 것이 최악의 경우!
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)

			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth"); 
				Date 	  rdate = rs.getDate("rdate"); 
				String    address = rs.getString("address");
				
				dto = new MemberDto(id,pw,name, phone1, phone2, phone3, gender, email, birth, rdate, address);
			} 
		} catch (Exception e) {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 5. 회원정보 수정 : public menberDto modifyMember(MemberDto dto) 
	public int modifyMember(MemberDto dto) {
		int result = FAIL; // insert가 안되는 상황
		// dto DB에 insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET PW = ?, " + 
				"                  NAME =  ?, " + 
				"                  PHONE1 = ?," + 
				"                  PHONE2 = ?," + 
				"                  PHONE3 = ?," + 
				"                  GENDER = ?," + 
				"                  EMAIL = ?," + 
				"                  BIRTH = ?," + 
				"                  ADDRESS = ?" + 
				"        WHERE ID =?";
		try {
			conn = getConnection(); // 드라이버 호출
			pstmt = conn.prepareStatement(sql);
			// 값 넣어주기
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			// sql 문 전송
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS? "회원수정성공" : "회원수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원 수정 실패 : " + dto/* .toString() */);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	
	
}
