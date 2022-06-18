package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BWriteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		
		BoardDao bDao = BoardDao.getInstance();
		
		request.setAttribute("writeResult", bDao.write(bname, btitle, bcontent, bip));
		// success면 1 리턴, fail이면 0 리턴하는 로직 추가
	}

}
