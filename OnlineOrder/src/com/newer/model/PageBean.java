package com.newer.model;

import java.util.ArrayList;
import java.util.List;

/*
 * 封装分页所需要的数据和方法
 */
public class PageBean<T> {
	private int pageNo;//页号
	private int pageSize;//页大小
	private List<T> data=new ArrayList<T>();//单页数据
	private int totalRows;//总记录条数
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	/*
	 * 获得总页数的方法
	 */
	public int getTotalPage(){
		return (totalRows+pageSize-1)/pageSize;
	}
	
	/*
	 * 获得首页页号
	 */
	public int getFirstPage(){
		return 1;
	}
	/*
	 * 获得末页页号
	 */
	public int getLastPage(){
		return this.getTotalPage();
	}
	
	/*
	 * 获得上一页页号
	 */
	public int getUpPage(){
		return this.pageNo==1?1:this.pageNo-1;
	}
	
	/*
	 * 获得下一页页号
	 */
	public int getDownPage(){
		return this.pageNo==this.getTotalPage()?this.pageNo:this.pageNo+1;
	}

}
