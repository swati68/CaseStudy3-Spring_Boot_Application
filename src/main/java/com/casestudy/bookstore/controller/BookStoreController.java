package com.casestudy.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.bookstore.entity.Book;
import com.casestudy.bookstore.entity.User;
import com.casestudy.bookstore.entity.UserOrders;
import com.casestudy.bookstore.service.BookService;
import com.casestudy.bookstore.service.UserOrdersService;
import com.casestudy.bookstore.service.UserService;

@RestController
public class BookStoreController {
	@Autowired
	private BookService bookservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private UserOrdersService orderservice;
	
	
	//View All Books
	@GetMapping("/books")
	public List<Book> fetchBooks(){
		return bookservice.fetchBooks();
	}
	
	
	//View Book by Name
	@GetMapping("/books/bookname/{bname}")
	public List<Book> fetchByBook(@PathVariable("bname") String bname){
		return bookservice.fetchByBook(bname);
	}
	
	
	//View Book by AuthorName
	@GetMapping("/books/author/{aname}")
	public List<Book> fetchByAuthor(@PathVariable("aname") String aname){
		return bookservice.fetchByAuthor(aname);
	}
	
	
	//View Book by GenreName
	@GetMapping("/books/genre/{gname}")
	public List<Book> fetchByGenre(@PathVariable("gname") String gname){
		return bookservice.fetchByGenre(gname);
	}
	
	//Add a New Book
	@PostMapping("/books")
	public Book addBooks(@RequestBody Book book) {
		return bookservice.addBooks(book);
	}
	
	//Update exisitng Book
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		return bookservice.updateBook(book, id);
	}
	
	//Delete a book
	@DeleteMapping("/books/{id}")
	public String deleteBooks(@PathVariable("id") int id) {
		bookservice.deleteBook(id);
		return "Deleted Successfully";
	}
	
	//View all users
	@GetMapping("/users")
	public List<User> fetchAllUsers(){
		return userservice.fetchAllUsers();
	}
	
	//Add a user
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}
	
	
	//View All orders
	@GetMapping("/orders")
	public List<UserOrders> fetchAllOrders(){
		return orderservice.fetchAllOrders();
	}
	
	//View order of a particular customer
	@GetMapping("/orders/{id}")
	public List<UserOrders> fetchById(@PathVariable("id") int id) {
		return orderservice.fetchByUserId(id);
	}
	
	//Place order of a customer
	@PostMapping("/orders/{uid}/{bid}")
	public UserOrders addOrders(@PathVariable("uid") int uid,@PathVariable("bid") int bid) {
		UserOrders order = new UserOrders();
		order.setBookid(bid);
		order.setUserid(uid);
		return orderservice.addOrder(order);
	}
}
