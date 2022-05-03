package com.lec.ex1_person;
// 1. �Է� / 2. ������ ��ȸ / 3. ��ü ��ȸ / �׿� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		String fn, sql;
		
		Connection        conn  = null;
		Statement         stmt  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
				
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			System.out.print("1. �Է� | 2. ��������ȸ | 3. ��ü��ȸ | 4. �׿� : ����");
			fn = sc.next(); // 123,a
			switch(fn) { // ����, ����
			case "1": 
				System.out.println("1. �Է��� �̸�, ������, ��, ��, �� �Է� �޾� insert");
				sql = "INSERT INTO PERSON VALUES" + 
						"    (PERSON_NO_SEQ.NEXTVAL, ?, (SELECT jNO FROM JOB WHERE jNAME = ?), ?, ?, ?)";
				System.out.print("�̸� : ");
				String pname = sc.next();
				System.out.print("������ : ");
				String jname = sc.next();
				System.out.print("�������� : ");
				int kor = sc.nextInt();
				System.out.print("�������� : ");
				int eng = sc.nextInt();
				System.out.print("�������� : ");
				int mat = sc.nextInt();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է� ����" : "�Է½���");
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {}
				}
				
				break;
				
			case "2":
				System.out.println("2. �������� �Է� �޾� �ش� ������ ��ȸ ���");
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT pNAME ||'('||PNO||'��)' pNAME, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"SUM\"" + 
						"    FROM PERSON P, JOB J WHERE P.jNO = J.jNO AND JNAME = ? ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.print("������ (���? ����?)");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t�̸�\t\t����\t��\t��\t��\t����");
						do {
							int rank = rs.getInt("rank");
							pname = rs.getString("pname");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"��\t" + pname +"\t"+jname +"\t"+ kor+"\t"+eng+"\t"+mat+"\t"+sum);
						} while (rs.next());
					} else {
						System.out.println("�ش� ���� ��� x");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) rs.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {}
				}
				
				break;
				
			case "3":
				System.out.println("3. ��ü ���");
				// 2~7�ܰ�
				sql = "SELECT ROWNUM RANK, A.*" + 
						"    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, "+
													 "MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO=J.JNO" + 
						"            ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
//					pstmt = conn.prepareStatement(sql); // (3) - sql�� ǰ�� ����
					stmt = conn.createStatement();
//					rs = pstmt.executeQuery(); // (4) + (5)
					rs = stmt.executeQuery(sql); // - ���߿� �Ѹ��� �뵵
					if(rs.next()) { // ������ ���
						System.out.println("rank\t�̸�\t����\t��\t��\t��\t����");
						do {
							int rank  = rs.getInt("rank");
							pname     = rs.getString("pname");
							jname     = rs.getString("jname");
							kor       = rs.getInt("kor");
							eng       = rs.getInt("eng");
							mat       = rs.getInt("mat");
							int sum   = rs.getInt("sum");
							System.out.println(rank+"��\t"+pname+"\t\t"+jname+"\t"+kor+"\t"+
									eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� �Էµ��� �ʾҽ��ϴ�");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e) {
						
					}
				}
				
				break;
			}
			
			
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("���α׷� ����");

	}

}
