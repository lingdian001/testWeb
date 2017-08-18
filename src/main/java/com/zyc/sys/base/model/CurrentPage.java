package com.zyc.sys.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CurrentPage<T extends BasePO, V extends BaseVO> implements
		Serializable {
	/**
	 * @Fields serialVersionUID : 序列号
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 构造方法
	 * </p>
	 */
	public CurrentPage() {

	}

	/**
	 * 当前多少页，默认第1页
	 */
	private int pageNo = 1;
	/**
	 * 当前页按多少条，默认每页10条
	 */
	private int pageSize = 10;

	/**
	 * 符合条件的记录共多少条
	 */
	private int total;

	/**
	 * 总页数
	 */
	private int pageTotal;

	/**
	 * 每页的条目信息
	 */
	private List<T> pageItems = new ArrayList<T>();

	/**
	 * 最多返回多少条记录，默认1000条
	 */
	private int maxSize = 1000;

	/**
	 * 按条件查询的对象
	 */
	private V paramObject;

	/**
	 * 获取查询条件封装的对象
	 * 
	 * @return V
	 */
	public V getParamObject() {
		return paramObject;
	}

	/**
	 * 设置查询条件封装的对象
	 * 
	 * @param paramObject
	 *            V
	 */
	public void setParamObject(V paramObject) {
		this.paramObject = paramObject;
	}

	/**
	 * 符合条件的记录共多少条
	 * 
	 * @return int
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 设置条件的记录共多少条
	 * 
	 * @param total
	 *            int
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 返回当前多少页
	 * 
	 * @return int
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前多少页
	 * 
	 * @param pageNo
	 *            int
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 每页返回多少条
	 * 
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页返回多少条
	 * 
	 * @param pageSize
	 *            int
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 最多返回多少条记录，默认1000条
	 * 
	 * @return int
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * 设置最多返回多少条记录，默认1000条
	 * 
	 * @param maxSize
	 *            int
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * 获取总页数
	 * 
	 * @return int
	 */
	public int getPageTotal() {
		return pageTotal;
	}

	/**
	 * 设置总页数
	 * 
	 * @param pageTotal
	 *            int
	 */
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	/**
	 * 返回每页的条目信息
	 * 
	 * @return List<T>
	 */
	public List<T> getPageItems() {
		return pageItems;
	}

	/**
	 * 设置每页的条目信息
	 * 
	 * @param pageItems
	 *            List<T>
	 */
	public void setPageItems(List<T> pageItems) {
		this.pageItems = pageItems;
	}

	/**
	 * 获取当前泛型类的类型
	 * 
	 * @return Class
	 */
	public Class getClazz() {
		if (null != getParamObject()) {
			return getParamObject().getClass();
		} else {
			return new BaseVO().getClass();
		}
	}

}
