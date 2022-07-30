package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping(value="book")
public class BookController {
	
	// bookService 가져오기
	@Autowired
	private BookService bookService;
	
	// 책 등록폼 뷰단
	@RequestMapping(params="method=registerForm", method=RequestMethod.GET)
	public String registerForm() {
		return "book/registerForm";
	}
	
	// 책 등록 진행
	@RequestMapping(params="method=register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, Book book, Model model) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "redirect:book.do?method=registerForm";
	}
	
	// 책 리스트 출력
	@RequestMapping(params="method=list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("bookList", bookService.bookList(pageNum));
		model.addAttribute("paging", new Paging(bookService.totCntBook(), pageNum, 3, 3));
		return "book/list";		
	}
	
	// 책 상세보기 출력
	@RequestMapping(params="method=detail", method=RequestMethod.GET)
	public String detail (int bnum, Model model) {

		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	
	// 책 정보 수정 폼
	@RequestMapping(params="method=modifyForm", method=RequestMethod.GET)
	public String modifyForm(int bnum, Model model) {
		
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/modifyForm";
	}
	
	// 책 정보 수정 진행
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, @ModelAttribute("bDto") Book book, Model model, String pageNum) {
		
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));
		return "redirect:book.do?method=list&pageNum="+pageNum;
	}
	
	
}
