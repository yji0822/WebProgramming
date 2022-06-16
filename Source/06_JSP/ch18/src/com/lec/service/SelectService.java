package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum 받아서  존재하면 페이지 넘버 넘기고 아니면 1페이지 출력하고..
		// arraylist받아서 쓰는 함수 호출하고..
		
		//뷰단에서 필요한 친구라 request.setAttribute 다 해주어야 한다.(나중에_)
		/*
		 * int currentPage; ArrayList<Dto> dtos = dao.list(startRow, endRow); int
		 * pageCnt, startPage, endPage;
		 */
		request.setAttribute("list", "list결과");
	
	}

}
