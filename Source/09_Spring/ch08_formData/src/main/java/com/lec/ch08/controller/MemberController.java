package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")
public class MemberController {
	
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
	
	@RequestMapping(value="join1") // 요청경로: member/join1	
	public String join1(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String pw   = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// 입력받아준 것 뿌려주기
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age); // new Integer(age)
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}
	
	
	// 잘 사용 안하는 방식.
	@RequestMapping(value="join2")
	public String join2(@RequestParam("name") String membername,
			@RequestParam("id") String memberid,
			@RequestParam("pw") String memberpw,
			@RequestParam("age") String memberage,
			@RequestParam("email") String memberemail,
			@RequestParam("address") String memberaddress, Model model) {
		
		model.addAttribute("name", membername);
		model.addAttribute("id", memberid);
		model.addAttribute("pw", memberpw);
		model.addAttribute("age", memberage);
		model.addAttribute("email", memberemail);
		model.addAttribute("address", memberaddress);
		
		return "member/result1";
	}
	
	
	// 은근 자주 쓰이는 방식
	@RequestMapping(value="join3")
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age",age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
		
	}
	
	/* 이런 거 안함!
	 * @RequestMapping(value="join4")
	public String join4(String name, String id, String pw, int age, String email, String address, Model model) {
		
		MemberDto member = new MemberDto();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setAge(age);
		member.setEamil(email);
		member.setAddress(address);
		model.addAttribute("member", member);
		return "member/result4";
	} */
	
	// member.id..
	@RequestMapping(value="join4")
	public String join4(MemberDto memberDto, Model model) {
		// 각각 따로 받는 것을 그냥 Dto로 받아준다 / id는 id로 pw는 pw로 알아서 받아들여오는 방법
		// 위의 귀찮은 방식보다 훨씬 간편
		model.addAttribute("member", memberDto);
		return "member/result4"; // 받아와서 출력하는 것이 아니라 dto를 받아와서 getter 출력을 하기 때문에 새로운 파일을 만들어 주어야 한다. 
	}
	
	// model에 memberDto가 들어가있는 것
	// 소문자로 변수명을 똑같이 만들어줬는지 확인? / memberDto에 다 받아오려면 memberDto.id 가 되려면 매개변수 없는 생성자가 반드시 필요하다.
	@RequestMapping(value="join5")
	public String join5(MemberDto memberDto/*, Model model*/) {
		// model.addAttribute("member", memberDto);
		return "member/result5"; 
	}
	
	@RequestMapping(value="join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4"; // 받아와서 출력하는 것이 아니라 dto를 받아와서 getter 출력을 하기 때문에 새로운 파일을 만들어 주어야 한다. 
	}
	
	
	
}
