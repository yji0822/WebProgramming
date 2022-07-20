package com.lec.ch12.bservice;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.dto.BoardDto;
public class BModifyService implements Service {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDto bDto = (BoardDto) map.get("boardDto");
		bDto.setBip(request.getRemoteAddr()); // ip 주소를 받아오기 위해서 request HttpServlet을 만들어준 것이다.
		BoardDao boardDao = BoardDao.getInstance();
		// boardDao.modify(bDto); // 성공/실패 여부 뷰단에 출력 안함
		model.addAttribute("modifyResult", boardDao.modify(bDto)); // 성공/실패 여부 뷰단에 출력
	}
}















