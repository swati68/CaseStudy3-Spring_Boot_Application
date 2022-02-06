package com.casestudy.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByAuthorname(String aname);

	List<Book> findByGenrename(String gname);

	List<Book> findByBookname(String bname);

}
