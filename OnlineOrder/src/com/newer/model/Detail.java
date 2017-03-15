package com.newer.model;

public class Detail {
	
	private int did;
	private int cate_id;
	private int id;
	private int amount;
	private String cate_name;
	private double price;
	private String picture;
	private String describe;
	
	public Detail() {
		
	}
	
	public Detail(int did, int cate_id, int id, int amount, String cate_name, double price, String picture,
			String describe) {
		this.did = did;
		this.cate_id = cate_id;
		this.id = id;
		this.amount = amount;
		this.cate_name = cate_name;
		this.price = price;
		this.picture = picture;
		this.describe = describe;
	}



	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "Detail [did=" + did + ", cate_id=" + cate_id + ", id=" + id + ", amount=" + amount + ", cate_name="
				+ cate_name + ", price=" + price + ", picture=" + picture + ", describe=" + describe + "]";
	}

}
