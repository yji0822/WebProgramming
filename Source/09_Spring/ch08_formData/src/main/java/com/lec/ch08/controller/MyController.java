package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@ModelAttribute("cnt") // 모든 함수에서 적용이 된다.  model.addAttribute("cnt", 5);
	public int cnt() {
		return 5;
	}
	
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}

	@RequestMapping(value="/") // /로 가면 어디로 가라를 하기 때문에 공통경로를 적어주지 않을 것
	public String input() {
		// 뷰를 리턴하기 위해 String 사용
		//model.addAttribute("cnt", 5);
		return "member/input"; // 방금만든 input.jsp로 넘어간다.
	}
	
	/* 방법1
	// studentId/aaa or studentId/bbb or studentId/홍홍홍 모두를 받아오는 것
	// url로 
	@RequestMapping(value="studentId/*")
	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		// aaa만 뽑고 싶을때는?
		String uri = request.getRequestURI(); // jsp에서 했던 것과 동일 - "/ch08/studentId/aaa"
		String id = uri.substring(uri.lastIndexOf("/")+1); // 마지막에서 보이는 첫번째 / 에서 +1 까지 받아오는것 // 에러가 난다
		id = URLDecoder.decode(id, "utf-8");
		
		model.addAttribute("id", id);
		
		return "studentId";
	}
	*/
	
	// 방법2
	@RequestMapping(value="studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "studentId";
	}
	
	
}
