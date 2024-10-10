package com.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.in.entiry.Book;
import com.in.repo.BookRepo;
@Service
public class DemoService implements BookService{

	
	@Autowired
	private BookRepo repo;
	
	@Override
	public List<Book> getAllBooks() {
		
		return (List<Book>) repo.findAll();
	}

	@Override
	public boolean saveBook(Book book) {
		
		Book savebook=repo.save(book);
		if(savebook.getId() !=null)
		{
			return true;
		}
		
		return false;
	}
     
	public void deletebook(Integer id) {
		 repo.deleteById(id);
		
	}

	@Override
	public Book getById(Integer id) 
	{
		Optional<Book> findbyid=repo.findById(id);
		if(findbyid.isPresent())
		{
			return findbyid.get();
		}
		return null;
		
		
	}

}
