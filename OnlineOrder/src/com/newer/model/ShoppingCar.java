package com.newer.model;

public class ShoppingCar {
	
	private int sid;
	private int cate_id;
	private String cate_name;
	private double price;
	private int amount;
	private int user_id;
	private String picture;
	
	public ShoppingCar() {
		
	}

	public ShoppingCar(int sid, int cate_id, String cate_name, double price, int amount, int user_id, String picture) {
		this.sid = sid;
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.price = price;
		this.amount = amount;
		this.user_id = user_id;
		this.picture = picture;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "ShoppingCar [sid=" + sid + ", cate_id=" + cate_id + ", cate_name=" + cate_name + ", price=" + price
				+ ", amount=" + amount + ", user_id=" + user_id + ", picture=" + picture + "]";
	}

}
