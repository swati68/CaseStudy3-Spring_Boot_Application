package com.casestudy.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.bookstore.entity.User;
import com.casestudy.bookstore.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	
	public List<User> fetchAllUsers(){
		return (List<User>)userrepo.findAll();
	}
	
	public User addUser(User user) {
		return userrepo.save(user);
	}
	
}
