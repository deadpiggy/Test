package com.newer.model;

public class CatePojo {

	private int cate_id1;
	private int cate_id2;
	private String cate_name;
	private double price;
	
	public CatePojo() {
		
	}
	
	public CatePojo(int cate_id1, int cate_id2, String cate_name, double price) {
		this.cate_id1 = cate_id1;
		this.cate_id2 = cate_id2;
		this.cate_name = cate_name;
		this.price = price;
	}
	public int getCate_id1() {
		return cate_id1;
	}
	public void setCate_id1(int cate_id1) {
		this.cate_id1 = cate_id1;
	}
	public int getCate_id2() {
		return cate_id2;
	}
	public void setCate_id2(int cate_id2) {
		this.cate_id2 = cate_id2;
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
	
}
