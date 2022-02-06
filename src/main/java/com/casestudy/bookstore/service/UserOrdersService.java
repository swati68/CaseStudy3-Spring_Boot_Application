package com.casestudy.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.bookstore.entity.UserOrders;
import com.casestudy.bookstore.repository.UserOrdersRepository;

@Service
public class UserOrdersService {
	@Autowired
	private UserOrdersRepository orderrepo;
	
	public List<UserOrders> fetchAllOrders(){
		return (List<UserOrders>)orderrepo.findAll();
	}
	
	public UserOrders addOrder(UserOrders order) {
		return orderrepo.save(order);
	}
	
	public List<UserOrders> fetchByUserId(int uid) {
		return (List<UserOrders>)orderrepo.findByUserid(uid);
	}
}
