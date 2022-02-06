package com.casestudy.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bookstore.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
