package com.newer.model;

import java.util.Date;

public class OrderNum {

	private int id;
	private int user_id;
	private Date order_date;
	private int type;
	private String address;
	private String words;
	private String status;
	private String phone;
	
	public OrderNum() {		

	}

	public OrderNum(int id, int user_id, Date order_date, int type, String address, String words, String status,
			String phone) {
		this.id = id;
		this.user_id = user_id;
		this.order_date = order_date;
		this.type = type;
		this.address = address;
		this.words = words;
		this.status = status;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "OrderNum [id=" + id + ", user_id=" + user_id + ", order_date=" + order_date + ", type=" + type
				+ ", address=" + address + ", words=" + words + ", status=" + status + ", phone=" + phone + "]";
	}
	
}
