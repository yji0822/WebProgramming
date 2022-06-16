package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		/* int result = dao.delete(request.getParameter("num")); */
		int result = 1; // success
		request.setAttribute("deleteResult", result);
	}

}
