package com.zyc.sys.base;

import java.util.ArrayList;
import java.util.List;

public class CurrentPage<T> {
	private int total;			//总条数
	private int pageNo;			//当前页数
	private int pageSize;		//每页显示条数
	private int pageMaxSize;	//每页显示最大条数
	private int pageTotal;		//总页数
	private List<T> pageItems;	//存储的内容
	
	public CurrentPage(){
		pageNo=1;
		pageMaxSize=1000;
		pageItems = new ArrayList<T>();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

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

	public int getPageMaxSize() {
		return pageMaxSize;
	}

	public void setPageMaxSize(int pageMaxSize) {
		this.pageMaxSize = pageMaxSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<T> getPageItems() {
		return pageItems;
	}

	public void setPageItems(List<T> pageItems) {
		this.pageItems = pageItems;
	}
	
	

}
