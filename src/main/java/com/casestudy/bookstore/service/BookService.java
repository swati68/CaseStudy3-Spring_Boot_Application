package com.casestudy.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.bookstore.entity.Book;
import com.casestudy.bookstore.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookrepo;
	
	public List<Book> fetchBooks()
    {
        return (List<Book>)
            bookrepo.findAll();
    }
	
	public List<Book> fetchByAuthor(String aname){
		return (List<Book>)bookrepo.findByAuthorname(aname);
	}
	
	public List<Book> fetchByGenre(String gname){
		return (List<Book>)bookrepo.findByGenrename(gname);
	}
	
	public List<Book> fetchByBook(String bname){
		return (List<Book>)bookrepo.findByBookname(bname);
	}
	
	public Book addBooks(Book book)
    {
        return bookrepo.save(book);
    }
	
	public Book updateBook(Book book,int id) {
		Book old = bookrepo.findById(id).get();
		
		if (Objects.nonNull(book.getBookname()) && !"".equalsIgnoreCase(book.getBookname())) {
	           	old.setBookname(book.getBookname());
	    }
		if (Objects.nonNull(book.getAuthorname()) && !"".equalsIgnoreCase(book.getAuthorname())) {
           	old.setAuthorname(book.getAuthorname());
    }
		if (Objects.nonNull(book.getGenrename()) && !"".equalsIgnoreCase(book.getGenrename())) {
           	old.setGenrename(book.getGenrename());
    }
		if (Objects.nonNull(book.getPrice())) {
           	old.setPrice(book.getPrice());
    }
		if (Objects.nonNull(book.getQuantity())) {
           	old.setQuantity(book.getQuantity());
    }
		return bookrepo.save(old);
	}
	
	public void deleteBook(int id) {
		bookrepo.deleteById(id);
	}
}
