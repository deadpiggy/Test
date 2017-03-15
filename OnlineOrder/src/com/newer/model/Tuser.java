package com.newer.model;

public class Tuser {
	
	private int user_id;
	private String user_name;
	private String ch_name;
	private String password;
	private String mobile;
	private String sex;
	private int type;
	private String address;
	private String email;
	
	public Tuser() {
		
	}

	public Tuser(int user_id, String user_name, String ch_name, String password, String mobile, String sex, int type,
			String address, String email) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.ch_name = ch_name;
		this.password = password;
		this.mobile = mobile;
		this.sex = sex;
		this.type = type;
		this.address = address;
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tuser [user_id=" + user_id + ", user_name=" + user_name + ", ch_name=" + ch_name + ", password="
				+ password + ", mobile=" + mobile + ", sex=" + sex + ", type=" + type + ", address=" + address
				+ ", email=" + email + "]";
	}

}
