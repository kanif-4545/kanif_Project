package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.sym.Name;
import com.in.entiry.Book;
import com.in.service.DemoService;

import ch.qos.logback.core.model.Model;

@Controller
public class ConClass {
	
	@Autowired
	private DemoService ser;
	
	@GetMapping("/index")
     public ModelAndView save(Book book)
     {
    	 ModelAndView mav=new ModelAndView();
    	 mav.addObject("book",new Book());
    	 
    	 mav.setViewName("index");
		return mav;
    	 
     }
	@GetMapping("/books")
	public ModelAndView getbook()
	{
			ModelAndView mav = new ModelAndView();
			List<Book> allBooks = ser.getAllBooks();
			mav.addObject("books", allBooks);
			mav.setViewName("bookview");
			return mav;
		}
	
	@PostMapping("/book")
	public ModelAndView saveBook(Book book)
	{
		ModelAndView vi=new ModelAndView();
		
		boolean  status=ser.saveBook(book);
		if(status)
		{
			vi.addObject("succ","Book saved");
		}
		else
		{
			vi.addObject("err","failed");
		}
		vi.setViewName("index");
		
		return vi;
		
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Integer bookid)
	{
		ser.deletebook(bookid);
		
		ModelAndView mav = new ModelAndView();
		List<Book> allBooks = ser.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("bookview");
		return mav;
	
		
	}
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam("id") Integer bookid)
	{
		 Book bobj=ser.getById(bookid);
		
		 ModelAndView mav=new ModelAndView();
    	 mav.addObject("book",bobj);
    	 
    	 mav.setViewName("index");
		return mav;

		
	}
	
	
	}
	


