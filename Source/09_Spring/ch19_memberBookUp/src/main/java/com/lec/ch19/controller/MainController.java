package com.lec.ch19.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.BookService;

@Controller
public class MainController {
	
	@Autowired
	private BookService bookService; // 북서비스 가져오기
	
	// main.do만 처리하는 컨트롤러
	// 작업을 하다가 다시 메인으로 돌아오도록 할 수 있으므로 POST도 함께 추가해놓는다.
	@RequestMapping(value="main", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model) {
		model.addAttribute("mainList", bookService.mainList()); // 신규 도서 순으로 리스트 출력해서 가져오는 것 (main단에서 가져오기)
		
		return "main/main"; // main.jsp - 무조건 main으로 가면 안된다.
		// views 안에 하위 폴더가 들어가있음
	}
	
}
