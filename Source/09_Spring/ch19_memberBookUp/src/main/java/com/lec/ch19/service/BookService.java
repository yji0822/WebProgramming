package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(String pageNum); // 페이징 처리를 하기 위해서
	public int totCntBook();
	public Book getDetailBook(int bnum);
	// 이미지를 첨부해야하는 로직 - 파일이름을 받아오기 위한 변수 mRequest 
	// 첫번째 파일이름 있니 불러와서 저장
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	public int registerBook(MultipartHttpServletRequest mRequest); // 별로 추천하지 않음
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	public int modifyBook(MultipartHttpServletRequest mRequest); // 별로 추천하지 않음
	
}
