package com.lec.ch13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch13.service.fileUploadService;

@Controller
public class FileController {
	
	// 파일 업로드 서비스 - new 하지 않도록 컨트롤로에서 추가 autowired
	@Autowired
	private fileUploadService fService;
	
	// 어노테이션이 있으면 알아서 만들어준다
	@RequestMapping(value="fileInput", method=RequestMethod.GET)
	public String fileInput() {
		return "fileInput";
		// 파일 업로드가 3개까지 가능하도록
	}
	
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public ModelAndView fileupload(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		// MemberDto memberDto 와 동일하도록 multipartRequest 사용 (HttpServletRequest request)
		if(fService.fileUp(mRequest, mav)) { // addAttribute까지 끝난 상태
			mav.addObject("fileResult", "파일 업로드 성공");
		} else {
			mav.addObject("fileResult", "파일 업로드 실패");
		}
		
		mav.setViewName("fileResult"); // 뷰 이름 - fileResult.jsp
		
		return mav;
		
	} //fileupload
	
	
}
