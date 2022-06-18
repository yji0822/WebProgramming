package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BModifyService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 받았던 것들 모두 불러오는 작업
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr(); //ip 주소 호출
		
		//modify 함수 호출
		BoardDao bDao = BoardDao.getInstance();
		request.setAttribute("modifyResult", bDao.modify(bid, bname, btitle, bcontent, bip));
		
	}

}
