package com.lec.ch19.dao;

import java.util.List;

import com.lec.ch19.dto.Book;

public interface BookDao {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registerBook(Book book);
	public int modifyBook(Book book);
}
