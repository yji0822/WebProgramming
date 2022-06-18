package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	
	// 기능을 딸깍 끼워서 딸깍 빼기
	public void excute(HttpServletRequest request, HttpServletResponse response);
	
}
