package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.controller.Service;
import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> members = mDao.listMember();
		
		// 뷰 단에 뿌려줄 건 무조건 request.setAttribute
		request.setAttribute("memberList", members);
	}

}
