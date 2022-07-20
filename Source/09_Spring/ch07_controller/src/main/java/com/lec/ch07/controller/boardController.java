package com.lec.ch07.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

@Controller // 컨트롤러로 인식하도록
@RequestMapping("board") // 공통요청경로
public class boardController {
	
	// board/write, board/content, board/list, board/reply
	
	// 슬래시를 넣어주어도 되고 안넣어 주어도 된다.
	// 공통적으로 들어가는 board를 위로 올려준다. - 공통요청경로
	
	@RequestMapping(value="write") // 조합된 요청경로 : board/write
	// 메소드
	public String write() {
		// 전달할 것이 없으면 파라미터 필요 없다.
		return "board/write"; // 뷰 : /WEB-INF/views/board/write.jsp
		// 뷰단. 이친구도 조합이 필요하다.
	}
	
	// get 방식이냐 post 방식이냐 지정해주는 것 
	// content로  들어온 것이  get방식이면 실행하는 것. post 방식은 들어오지 않는다.
	// RequestMethod.GET import 해와야 한다.
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model/*, HttpServletRequest request*/) {
		// request.setAttribute("id", aaa);
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "111"); // 객체도 add 할 수 있다. - MemberDto 존재함
		model.addAttribute("member", member);
		
		// 뷰단 return 해주기
		return "board/content";
	}

	// Model은 addAttribute만 가능 String도 가능한? ModelAndView
	// String 으로 리턴하는 것이 아닌 다른 방법
	// ModelAndView : Model도 있고 View도 있는 것
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		
		// member 받아오고 arraylist로 받아와서 저장하는 방식
		Member member = new Member("ccc", "111");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		
		mav.addObject("list", list); // model.addAttribute("list",list);
				
		mav.setViewName("board/list"); // 뷰단으로 넘겨주려면 setViewName으로 mav에 저장을 해주어야 한다.
		return mav;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		// new ModelAndView하기 싫으면 매개변수 안에 넣어주면 된다
		Member member = new Member("ddd", "111");
		mav.addObject("member", member);
		// 뷰단 생성 - 스프링은 반드시 뷰단으로 넘어가야 한다.
		mav.setViewName("board/reply");
		return mav;
		
	}
	
}
