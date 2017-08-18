package com.zyc.sys.base.model;

import com.zyc.sys.base.model.BaseBean;

/**
 * @author zyc
 * @date 创建时间：2017年9月6日 下午4:07:18 类说明 :po基类
 */

public class BasePO extends BaseBean {

	/**
	 * @Fields createDate : 创建日期
	 */
	protected String createDate;
	/**
	 * @Fields lastModifyDate : 修改日期
	 */
	protected String lastModifyDate;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

}
