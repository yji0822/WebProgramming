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

import com.lec.dto.FileboardDto;

public class FileboardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private static FileboardDao instance = new FileboardDao();

	public static FileboardDao getInstance() {
		return instance;
	}

	private FileboardDao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("커넥션 풀 이름 오류 : " + e.getMessage());
		}
		return conn;
	} // getConncetion()

	// ★★ 파일첨부게시판(FILEBOARD) 테이블 DAO ★★
	// 1. 글 목록 (starRow ~ endRow) : select
	public ArrayList<FileboardDto> listBoard(int startRow, int endRow) {
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * " + 
					 "    FROM (SELECT ROWNUM RN, A.* " + 
					 "            FROM (SELECT F.*, CNAME, CEMAIL " + 
					 "                    FROM FILEBOARD F, CUSTOMER C " + 
					 "                    WHERE F.CID = C.CID " + 
					 "                    ORDER BY FREF DESC, FRE_STEP) A) " + 
					 "    WHERE RN BETWEEN ? AND ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				 int    fnum     = rs.getInt("fnum");
				 String cid      = rs.getString("cid");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String fpw       = rs.getString("fpw");
				 int    fhit      = rs.getInt("fhit");
				 int    fref      = rs.getInt("fref");
				 int    fre_step  = rs.getInt("fre_step");
				 int    fre_level = rs.getInt("fre_level");
				 String fip       = rs.getString("fip");
				 Date   frdate    = rs.getDate("frdate");
				 String cname     = rs.getString("cname");
				 String cemail    = rs.getString("cemail");

				dtos.add(new FileboardDto(fnum, cid, fsubject, fcontent, 
							ffilename, fpw, fhit, fref, fre_step, fre_level, 
							fip, frdate, cname, cemail));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dtos;
	}

	// 2. 등록된 글 수 : select
	public int getFileboardCnt() {
		int totCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(*) FROM FILEBOARD";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next(); // 해주지 않으면 예외로 넘어가게 된다.
			totCnt = rs.getInt(1); // 첫번째 열을 가지고 오란 의미
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return totCnt;
	}

	// 3. 원글 쓰기 : insert
	public int insertBoard(FileboardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, "
													+ "FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
					 "    VALUES(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, "
					 								+ " ?, FILEBOARD_SEQ.CURRVAL ,0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
			
			result = pstmt.executeUpdate();
			System.out.println("게시글(원글) 쓰기 성공");
			
		} catch (SQLException e) {
			System.out.println("게시글(원글) 쓰기 실패: " + e.getMessage() + dto);
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
		
		return result;
	}
	
	// 4. 답변글 쓰기 전 step A : 5번글에 대한 답변글 쓰기 전처리 작업 : update
	// 답변글 쓰기 전에 호출 해서 사용할 예정.
	private void preReplyStepA(int fref, int fre_step) {
		// 0행 업데이트 될 때도 있고 10행 업데이트 될 때도 있으니까 return type이 굳이 필요 없다
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// restep을 1씩 증가 
		String sql = "UPDATE FILEBOARD SET FRE_STEP = FRE_STEP + 1 "
					+ "WHERE FREF = ? AND FRE_STEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fref);
			pstmt.setInt(2, fre_step);
			int result = pstmt.executeUpdate();
			
			System.out.println(result == 0 ? "첫 답변글 입니다." : result + "행 step 조정");
			// 에러가 나는 경우는 sql문을 잘못 가져온 경우 밖에 없다.
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
		
	}
	
	// 5. 답변글 쓰기 : 5번 글의 답변 : insert
	public int reply(FileboardDto dto) {
		// fref, fre_step, fre_level : 원글의 정보
		// cid, fsubject, fcontent, ffilename, fpw, fip : 답변글의 정보
		
		// 4. preReplyStepA를 호출해온다
		preReplyStepA(dto.getFref(), dto.getFre_step());
		int result = FAIL; // insertboard와 같은 구조
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, "
												+ "FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
								"    VALUES(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, "
					 							+ "? ,?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
		
			pstmt.setInt(6, dto.getFref()); // 답변글의 경우, 원글의 fref를 그대로 따른다
			pstmt.setInt(7, dto.getFre_step() + 1); // 답변글은 원글의 re_step + 1 로 해준다. 엑셀파일 참고
			pstmt.setInt(8, dto.getFre_level() + 1); // 답변글의 원글의 fre_level + 1로 해준다.
			
			pstmt.setString(9, dto.getFip());
			
			result = pstmt.executeUpdate();
			System.out.println("답변글 쓰기 성공");
		
		} catch (SQLException e) {
			// 예외가 발생이 되었을때 숫자가 올라갔는지 아닌지 확인하기 위해서
			dto.setFre_step(dto.getFre_step() + 1); // 데이터베이스에 실제로 들어가는 
			dto.setFre_level(dto.getFre_level() + 1); // 이렇게 저장하려고 하는데 실패했어! 라는 의미....
			System.out.println("답변글 쓰기 실패: " + e.getMessage() + dto);
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
		
		return result;
	}
	
	// 6. 글 상세보기 (fnum으로 dto 가져오기) : select
	public FileboardDto getBoard(int fnum) {
		FileboardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM FILEBOARD WHERE FNUM = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// int    fnum     = rs.getInt("fnum");
				String cid      = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw       = rs.getString("fpw");
				int    fhit      = rs.getInt("fhit");
				int    fref      = rs.getInt("fref");
				int    fre_step  = rs.getInt("fre_step");
				int    fre_level = rs.getInt("fre_level");
				String fip       = rs.getString("fip");
				Date   frdate    = rs.getDate("frdate");
				String cname     = rs.getString("cname");
				String cemail    = rs.getString("cemail");
				
				dto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, 
										fref, fre_step, fre_level, fip, frdate, cname, cemail);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dto;
	}
	
	// 7. 조회수 올리기 : UPDATE
	public void hitUp(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// restep을 1씩 증가 
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT+1 WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			
			int result = pstmt.executeUpdate();
			System.out.println("조회수 up 성공!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
	}
	
	
	// 8. 글 수정하기 : update
	public int updateBoard(FileboardDto dto) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE FILEBOARD SET FSUBJECT = ?," + 
					 "                     FCONTENT = ?," + 
					 "                     FFILENAME = ?," + 
					 "                     FPW = ?," + 
					 "                     FIP = ?" + 
					 "                WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum()); // 잘못된 번호를 검색하면 0으로 리턴 될 수 있다.
			
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글 수정 성공" : "해당 글 번호가 없습니다. 글 수정 실패");
			
		} catch (SQLException e) {
			System.out.println("글 수정 실패: " + e.getMessage() + dto);
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
		
		return result;
	}
	
	
	// 9. 글 삭제하기 : delete
	public int deleteBoard(int fnum, String fpw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			
			// 글번호가 없거나 비밀번호 오류.. 대부분 비밀번호 오류인 경우가 많다.
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글 삭제 완료" : "비밀번호 오류. 글 삭제 실패");
			
		} catch (SQLException e) {
			System.out.println("글 수정 실패: " + e.getMessage());
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage()); 
			}
		} // finally
		
		
		return result;
	}
	

}
