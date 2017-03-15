package com.newer.model;

import java.util.Date;

public class Discuss {

	private int dis_id;
	private int cate_id;
	private String user_name;
	private String content;
	private Date dis_date;
	private String img_path;
	
	public Discuss() {
		
	}

	public Discuss(int dis_id, int cate_id, String user_name, String content, Date dis_date, String img_path) {
		this.dis_id = dis_id;
		this.cate_id = cate_id;
		this.user_name = user_name;
		this.content = content;
		this.dis_date = dis_date;
		this.img_path = img_path;
	}

	public int getDis_id() {
		return dis_id;
	}

	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDis_date() {
		return dis_date;
	}

	public void setDis_date(Date dis_date) {
		this.dis_date = dis_date;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@Override
	public String toString() {
		return "Discuss [dis_id=" + dis_id + ", cate_id=" + cate_id + ", user_name=" + user_name + ", content="
				+ content + ", dis_date=" + dis_date + ", img_path=" + img_path + "]";
	}
	
}
