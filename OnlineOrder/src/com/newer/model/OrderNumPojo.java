package com.newer.model;

public class OrderNumPojo {
	private int user_id;
	private int id1;
	private int id2;
	private String status;
	private String order_date;
	
	public OrderNumPojo() {
		
	}

	public OrderNumPojo(int user_id, int id1, int id2, String status, String order_date) {
		super();
		this.user_id = user_id;
		this.id1 = id1;
		this.id2 = id2;
		this.status = status;
		this.order_date = order_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "OrderNumPojo [user_id=" + user_id + ", id1=" + id1 + ", id2=" + id2 + ", status=" + status
				+ ", order_date=" + order_date + "]";
	}

}
