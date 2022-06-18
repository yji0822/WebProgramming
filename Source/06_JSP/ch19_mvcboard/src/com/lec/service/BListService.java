package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// list.do 또는 list.do?pageNum=2 또는 list.do?pageNum=10
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		} // pageNum이 존재하지 않다면 1페이지로 세팅 후 출력해라
		
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지 받아오기
		
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		
		BoardDao bDao = BoardDao.getInstance();
		request.setAttribute("list", bDao.listBoard(startRow, endRow)); // ★글목록
		
		// 11~20까지 출력
		int totalCnt = bDao.getBoardTotalCnt(); // 등록된 글 개수
		int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE); // 페이지 개수
		int startPage = ((currentPage - 1)/BLOCKSIZE) * BLOCKSIZE + 1; // 시작페이지
		int endPage = startPage + BLOCKSIZE - 1;
		
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		// 필요한 아이 담아야 하는 작업
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // ★ 이하 페이지 관련 항목들
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); // integer 객체로 들어가게 된다.
		request.setAttribute("pageCnt", pageCnt);
	}

}
