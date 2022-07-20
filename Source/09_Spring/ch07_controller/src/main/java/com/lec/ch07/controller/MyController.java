package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	// 프로젝트 이름, 
	// http://localhost:8090/ch07/ -> 슬래시 요청이 있어야 한다. 요청처리
	@RequestMapping("/") // 슬래시 요청이 들어왔을 때 다음과 같은 함수를 처리해주란 의미 : value="/" 이 생략이 되어있는 상태임
	public String home(Model model) {
		// 뷰단에 전달을 해주기 위해서는 매개변수에 Model 추가 (import 필수)
		model.addAttribute("greeting", "안녕하십니까.... 스프링입니다..."); // 뷰단에 전달하고 싶은 것이 있을때 request.setAttribute와 동일 여러개 써도 됨
		return "main"; 
		// view단으로 넘기는 건데 main뷰단으로 넘기라는 의미
		//view : /WEB-INF/views/main.jsp 
	}
	
}
