package com.lec.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.controller.Service;
import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MemberJoinService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		// null일 수는 있지만 빈스트링 일 수는 없다
		Timestamp birth = null;
		if(! request.getParameter("birth").equals("")) {
			// 빈스트링으로 넘어오면.. birth를 null로 받아와야 한다.
			// 스페이스가 하나 꼭 반드시 들어가야 한다.
			birth = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");
		}
		// insert할 dto
		MemberDto member = new MemberDto(id, pw, name, birth, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(member);
		request.setAttribute("joinResult", result); // 회원가입 성공했으면 success 반환, 실패시 fail 반환
	}

}
