package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // ip주소: 내피씨를 뜻함
		
		Connection conn = null;
		
		try {
			// 1단계: 드라이버 로드
			Class.forName(driver); // 예외 처리 하기
			System.out.println("드라이버 로드 성공");
			// 2단계: db와 연결 객체 생성
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("orcle DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결 오류 : " + e.getMessage());
		} finally {
			// 연결 객체 해제 ★
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // main
} 
