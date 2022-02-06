package com.casestudy.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bookstore.entity.UserOrders;

public interface UserOrdersRepository extends JpaRepository<UserOrders,Integer>{

	List<UserOrders> findByUserid(int uid);

}
