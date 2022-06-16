package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int result = 1;
		request.setAttribute("updateResult", result);
	}

}
