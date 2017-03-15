package com.newer.model;

import java.util.Date;

public class Order {

	private int id;
	private int user_id;
	private int cate_id;
	private String cate_name;
	private String picture;
	private double price;
	private int amount;
	private String address;
	private String words;
	private String describe;
	private String status;
	private Date date;
	private String phone;
	private int type;
	
	public Order() {
		
	}

	public Order(int id, int user_id, int cate_id, String cate_name, String picture, double price, int amount,
			String address, String words, String describe, String status, Date date, String phone, int type) {
		this.id = id;
		this.user_id = user_id;
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.picture = picture;
		this.price = price;
		this.amount = amount;
		this.address = address;
		this.words = words;
		this.describe = describe;
		this.status = status;
		this.date = date;
		this.phone = phone;
		this.type = type;
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

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", cate_id=" + cate_id + ", cate_name=" + cate_name
				+ ", picture=" + picture + ", price=" + price + ", amount=" + amount + ", address=" + address
				+ ", words=" + words + ", describe=" + describe + ", status=" + status + ", date=" + date + ", phone="
				+ phone + ", type=" + type + "]";
	}

}
