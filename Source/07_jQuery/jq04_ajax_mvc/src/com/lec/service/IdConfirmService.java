package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		// 03 idConfirm.jsp
		
		// 1. mid 받고
		String mId = request.getParameter("mId");
		// 2. dao 받고
		MemberDao dao = MemberDao.getInstance();
		// 3. method 호출
		int result = dao.mIdConfirm(mId);
		
		// 4. 결과값으로 중복체크 진행 후 값 넘겨주기
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("idConfirmResult" , "중복된 아이디 입니다.");
		} else {
			request.setAttribute("idConfirmResult", "사용가능한 아이디 입니다.");
		}
	}
}
