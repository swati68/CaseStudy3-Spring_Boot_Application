package com.casestudy.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userid;
	private int bookid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "UserOrders [id=" + id + ", userid=" + userid + ", bookid=" + bookid + "]";
	}
}
