package com.newer.model;

public class Cate {
	
	private int cate_id;
	private String cate_name;
	private double price;
	private String img_path;
	private String describe;
	private String type;
	private String speces;
	private int status;
	
	public Cate() {
		
	}
	
	public Cate(int cate_id, String cate_name, double price, String img_path, String describe, String type,
			String speces, int status) {
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.price = price;
		this.img_path = img_path;
		this.describe = describe;
		this.type = type;
		this.speces = speces;
		this.status = status;
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
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpeces() {
		return speces;
	}
	public void setSpeces(String speces) {
		this.speces = speces;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Cate [cate_id=" + cate_id + ", cate_name=" + cate_name + ", price=" + price + ", img_path=" + img_path
				+ ", describe=" + describe + ", type=" + type + ", speces=" + speces + ", status=" + status + "]";
	}

}
