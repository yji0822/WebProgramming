package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	// request 타입은 frontController에서 확인을 해주자
	public void excute(HttpServletRequest request, HttpServletResponse response);
	
}
