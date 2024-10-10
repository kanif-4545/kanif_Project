package com.in.service;

import java.util.List;

import com.in.entiry.*;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public void deletebook(Integer id);
	
	public Book getById(Integer id);

}
